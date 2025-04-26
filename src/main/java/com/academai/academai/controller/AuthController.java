package com.academai.academai.controller;

import com.academai.academai.dto.user.JwtResponse;
import com.academai.academai.dto.user.LoginRequest;
import com.academai.academai.dto.user.RegistrationRequest;
import com.academai.academai.service.interfaces.AuthService;
import com.academai.academai.service.interfaces.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth")
public class AuthController {
    private final AuthService authService;
    private final UserService userService;

    @Operation(
            summary = "Регистрация учитель/студент",
            description = "Указать isStudent=true для студента, иначе создаётся учитель"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешная регистрация",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = JwtResponse.class)))
    })
    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody @Valid RegistrationRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @Operation(
            summary = "Регистрация учитель/студент",
            description = "Указать isStudent=true для студента, иначе создаётся учитель"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешная регистрация",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = JwtResponse.class)))
    })
    @PostMapping("register2")
    public ResponseEntity<?> register2(@RequestBody @Valid RegistrationRequest request) {
        if(!authService.addUser(request)){
            return ResponseEntity.badRequest().body("User already exists");
        }
        return ResponseEntity.ok(authService.register(request));
    }

    @GetMapping("/activate/{code}")
    public ResponseEntity<String> activateAccount(@PathVariable String code) {
        String isActivated = userService.activateUser(code);
        return ResponseEntity.ok(isActivated);
    }




    @Operation(summary = "Авторизация пользователя", description = "Возвращает access токен и устанавливает refresh в куку")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешный вход",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = JwtResponse.class)))
    })
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest loginRequest, HttpServletResponse response, HttpServletRequest request) {
        return ResponseEntity.ok(authService.login(loginRequest, response, request));
    }

    @Operation(summary = "Обновляет оба токена")
    @PostMapping("refresh-tokens")
    public ResponseEntity<?> refreshTokens(
            @CookieValue("refreshToken") UUID refreshToken,
            @RequestHeader("Fingerprint") String fingerprint,
            HttpServletResponse response,
            HttpServletRequest request
            )
    {
        return ResponseEntity.ok(authService.refresh(refreshToken, fingerprint, response, request));
    }

//    @Operation(summary = "Авторизация через Google",
//            description = "Принимает idToken, полученный от Google, и осуществляет вход пользователя")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Успешная авторизация",
//                    content = @Content(mediaType = "application/json",
//                            schema = @Schema(implementation = JwtResponse.class)))
//    })
//    @PostMapping("login/google")
//    public ResponseEntity<?> googleLogin(
//            @RequestBody @Valid GoogleLoginRequest loginRequest,
//            HttpServletResponse response,
//            HttpServletRequest request) {
//        return ResponseEntity.ok(authService.googleLogin(loginRequest, response, request));
//    }


    @GetMapping("google/callback")
    public void googleCallback(@RequestParam("code") String code,
                                            HttpServletRequest request,
                                            HttpServletResponse response) throws IOException, GeneralSecurityException {
        authService.handleGoogleRedirect(code, request, response);
    }

}
