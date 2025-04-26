package com.academai.academai.service.impl;

import com.academai.academai.config.JwtTokenProvider;
import com.academai.academai.dto.user.JwtResponse;
import com.academai.academai.dto.user.LoginRequest;
import com.academai.academai.dto.user.RegistrationRequest;
import com.academai.academai.entity.RefreshSession;
import com.academai.academai.entity.Role;
import com.academai.academai.entity.User;
import com.academai.academai.enums.RoleName;
import com.academai.academai.repository.RefreshSessionRepository;
import com.academai.academai.repository.UserRepository;
import com.academai.academai.service.interfaces.AuthService;
import com.academai.academai.service.interfaces.RoleService;
import com.academai.academai.service.interfaces.UserService;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    private final RefreshSessionRepository refreshSessionRepository;
    private final UserService userService;
    private final MailSender mailSender;
    @Value("${google.client-id}")
    private String googleClientId;

    @Value("${google.client-secret}")
    private String googleClientSecret;

    @Value("${google.redirect-uri}")
    private String googleRedirectUri;

    @Override
    public JwtResponse register(RegistrationRequest request){
        User user = new User();
        Role role;
        if (request.getIsStudent()){
            role = roleService.findByName(RoleName.ROLE_STUDENT.name());
        } else {
            role = roleService.findByName(RoleName.ROLE_TEACHER.name());
        }
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setEmail(request.getEmail());
        user.setEnabled(true);
        user.setRole(role);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        role.getUsers().add(user);
        userRepository.save(user);
        String token = jwtTokenProvider.generateToken(user.getEmail(), user.getRole().getRole());
        return new JwtResponse(token, user.getRole().getRole());
    }

    @Override
    public boolean addUser(RegistrationRequest request){
        User userFromDb = userRepository.findByEmail(request.getEmail()).orElse(null);
        if (userFromDb != null) return false;

        Role role;
        if (request.getIsStudent()){
            role = roleService.findByName(RoleName.ROLE_STUDENT.name());
        } else {
            role = roleService.findByName(RoleName.ROLE_TEACHER.name());
        }
        User user = new User()
                .setEnabled(false)
                .setName(request.getName())
                .setSurname(request.getSurname())
                .setEmail(request.getEmail())
                .setActivationCode(UUID.randomUUID().toString())
                .setRole(role)
                .setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
        if(!StringUtils.hasText(request.getEmail())){
            String message = String.format(
                    """
                            Hello, %s!
                            
                            Please activate your account by clicking on the link below:
                            
                            http://localhost:8080/api/auth/activate/%s
                            """,user.getEmail(),user.getActivationCode());
            mailSender.sendMail(user.getEmail(),"Activation code",message);
        }
        return true;
    }



    @Override
    public JwtResponse login(LoginRequest loginRequest, HttpServletResponse response, HttpServletRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );
        User user = userService.getUserByEmail(loginRequest.getEmail());
        String accessToken = jwtTokenProvider.generateToken(user.getEmail(), user.getRole().getRole());
        UUID refreshToken = UUID.randomUUID();
        List<RefreshSession> sessions = refreshSessionRepository.findByUserOrderByCreatedAtAsc(user, PageRequest.of(0, 5));
        if (sessions.size() >= 5) {
            refreshSessionRepository.deleteAll(sessions);
        }

        RefreshSession refreshSession = new RefreshSession();
        refreshSession.setRefreshToken(refreshToken);
        refreshSession.setUser(user);
        refreshSession.setFingerprint(request.getHeader("Fingerprint"));
        refreshSession.setUa(request.getHeader("User-Agent"));
        refreshSession.setIp(request.getRemoteAddr());
        refreshSession.setExpiresIn(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 30));
        refreshSessionRepository.save(refreshSession);

        Cookie cookie = new Cookie("refreshToken", refreshToken.toString());
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/api/auth");
        cookie.setMaxAge(60 * 60 * 24 * 30);
        response.addCookie(cookie);

        return new JwtResponse(accessToken, user.getRole().getRole());
    }


    @Transactional
    @Override
    public JwtResponse refresh(UUID oldToken, String fingerprint, HttpServletResponse response, HttpServletRequest request){
        RefreshSession session = refreshSessionRepository.findByRefreshToken(oldToken)
                .orElseThrow(() -> new NoSuchElementException("Refresh token not found"));
        if(!session.getFingerprint().equals(fingerprint)){
            throw new IllegalArgumentException("Fingerprint mismatch");
        }

        if (session.getExpiresIn() < System.currentTimeMillis()) {
            throw new IllegalArgumentException("Refresh expired");
        }

        refreshSessionRepository.deleteByRefreshToken(oldToken);
        User user = session.getUser();

        UUID newRefreshToken = UUID.randomUUID();
        RefreshSession newSession = new RefreshSession();
        newSession.setRefreshToken(newRefreshToken);
        newSession.setUser(user);
        newSession.setFingerprint(fingerprint);
        newSession.setUa(request.getHeader("User-Agent"));
        newSession.setIp(request.getRemoteAddr());
        newSession.setExpiresIn(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 30));
        refreshSessionRepository.save(newSession);

        String accessToken = jwtTokenProvider.generateToken(user.getEmail(), user.getRole().getRole());

        Cookie cookie = new Cookie("refreshToken", newRefreshToken.toString());
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/api/auth");
        cookie.setMaxAge(60 * 60 * 24 * 30);
        response.addCookie(cookie);
        return new JwtResponse(accessToken, user.getRole().getRole());
    }


//    @Override
//    public JwtResponse googleLogin(GoogleLoginRequest loginRequest, HttpServletResponse response, HttpServletRequest request) {
//        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier
//                .Builder(new NetHttpTransport(), GsonFactory.getDefaultInstance())
//                .setAudience(Collections.singletonList(googleClientId))
//                .build();
//
//        GoogleIdToken idToken;
//        try {
//            idToken = verifier.verify(loginRequest.getIdToken());
//        } catch (GeneralSecurityException | IOException e) {
//            throw new IllegalArgumentException("Ошибка при валидации Google токена", e);
//        }
//
//        if (idToken == null) {
//            throw new IllegalArgumentException("Неверный Google ID token");
//        }
//
//        GoogleIdToken.Payload payload = idToken.getPayload();
//        String email = payload.getEmail();
//
//        User user;
//        try {
//            user = userService.getUserByEmail(email);
//        } catch (NoSuchElementException e) {
//            user = new User();
//            Role role;
//            role = roleService.findByName(RoleName.ROLE_STUDENT.name());
//            user.setName((String) payload.get("given_name"));
//            user.setSurname((String) payload.get("family_name"));
//            user.setEmail(email);
//            user.setEnabled(true);
//            user.setRole(role);
//            user.setAvatar("user.png");
//            user.setPassword(passwordEncoder.encode(UUID.randomUUID().toString()));
//            role.getUsers().add(user);
//            userRepository.save(user);
//        }
//
//        String accessToken = jwtTokenProvider.generateToken(user.getEmail(), user.getRole().getRole());
//        UUID refreshToken = UUID.randomUUID();
//        List<RefreshSession> sessions = refreshSessionRepository.findByUserOrderByCreatedAtAsc(user, PageRequest.of(0, 5));
//        if (sessions.size() >= 5) {
//            refreshSessionRepository.deleteAll(sessions);
//        }
//
//        RefreshSession session = new RefreshSession();
//        session.setRefreshToken(refreshToken);
//        session.setUser(user);
//        session.setFingerprint(loginRequest.getFingerprint());
//        session.setUa(request.getHeader("User-Agent"));
//        session.setIp(request.getRemoteAddr());
//        session.setExpiresIn(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 30));
//        refreshSessionRepository.save(session);
//
//        Cookie cookie = new Cookie("refreshToken", refreshToken.toString());
//        cookie.setHttpOnly(true);
//        cookie.setSecure(true);
//        cookie.setPath("/api/auth");
//        cookie.setMaxAge(60 * 60 * 24 * 30);
//        response.addCookie(cookie);
//
//        return new JwtResponse(accessToken, user.getRole().getRole());
//    }

    @Override
    public void handleGoogleRedirect(String code, HttpServletRequest request, HttpServletResponse response) throws IOException, GeneralSecurityException {
        HttpTransport transport = new NetHttpTransport();
        JsonFactory jsonFactory = GsonFactory.getDefaultInstance();

        GoogleTokenResponse tokenResponse = new GoogleAuthorizationCodeTokenRequest(
                transport,
                jsonFactory,
                "https://oauth2.googleapis.com/token",
                googleClientId,
                googleClientSecret,
                code,
                googleRedirectUri
        ).execute();

        String idTokenString = tokenResponse.getIdToken();
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                .setAudience(Collections.singleton(googleClientId))
                .build();
        GoogleIdToken idToken = verifier.verify(idTokenString);

        if (idToken == null) {
            response.sendRedirect("http://academai.com/login?error=invalid_token");
            return;
        }

        GoogleIdToken.Payload payload = idToken.getPayload();
        String email = payload.getEmail();
        User user;
        try{
            user = userService.getUserByEmail(email);
        } catch (NoSuchElementException e){
            user = new User();
            Role role = roleService.findByName(RoleName.ROLE_STUDENT.name());
            user.setName((String) payload.get("given_name"));
            user.setEmail(email);
            user.setRole(role);
            user.setAvatar("user.png");
            user.setPassword(passwordEncoder.encode(UUID.randomUUID().toString()));
            role.getUsers().add(user);
            userRepository.save(user);
        }

        String accessToken = jwtTokenProvider.generateToken(user.getEmail(), user.getRole().getRole());
        UUID refreshToken = UUID.randomUUID();

        List<RefreshSession> sessions = refreshSessionRepository.findByUserOrderByCreatedAtAsc(user, PageRequest.of(0, 5));
        if (sessions.size() >= 5) {
            refreshSessionRepository.deleteAll(sessions);
        }

        RefreshSession session = new RefreshSession();
        session.setRefreshToken(refreshToken);
        session.setUser(user);
        session.setFingerprint("GOOGLE");
        session.setUa(request.getHeader("User-Agent"));
        session.setIp(request.getRemoteAddr());
        session.setExpiresIn(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 30));
        refreshSessionRepository.save(session);

        Cookie cookie = new Cookie("refreshToken", refreshToken.toString());
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/api/auth");
        cookie.setMaxAge(60 * 60 * 24 * 30);
        response.addCookie(cookie);

        response.sendRedirect("http://frontend-url.com/landing?accessToken=" + accessToken);
    }


}
