package com.example.springboot.config;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        // Log the failure (you could use a logger for production code)
        System.out.println("Authentication failed: " + exception.getMessage());

        // Redirect the user to the login page with an error message
        response.sendRedirect("/login?error=true");
    }
}