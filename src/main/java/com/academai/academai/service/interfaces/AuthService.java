package com.academai.academai.service.interfaces;

import com.academai.academai.dto.user.JwtResponse;
import com.academai.academai.dto.user.LoginRequest;
import com.academai.academai.dto.user.RegistrationRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.UUID;

public interface AuthService {
    JwtResponse register(RegistrationRequest request);

    boolean addUser(RegistrationRequest request);

    JwtResponse login(LoginRequest loginRequest, HttpServletResponse response, HttpServletRequest request);

    JwtResponse refresh(UUID oldToken, String fingerprint, HttpServletResponse response, HttpServletRequest request);

    void handleGoogleRedirect(String code, HttpServletRequest request, HttpServletResponse response) throws IOException, GeneralSecurityException;
}
