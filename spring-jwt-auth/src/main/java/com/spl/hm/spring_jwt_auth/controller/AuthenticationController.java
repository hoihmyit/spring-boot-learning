package com.spl.hm.spring_jwt_auth.controller;

import com.spl.hm.spring_jwt_auth.dto.AuthRequest;
import com.spl.hm.spring_jwt_auth.dto.AuthResponse;
import com.spl.hm.spring_jwt_auth.entity.User;
import com.spl.hm.spring_jwt_auth.service.AuthenticationService;
import com.spl.hm.spring_jwt_auth.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AuthenticationController {

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    @PostMapping("/auth/signup")
    public ResponseEntity<User> register(@RequestBody AuthRequest request) {
        User registeredUser = authenticationService.signup(request);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<AuthResponse> authenticate(
        @RequestBody AuthRequest request
    ) {

        User authenticatedUser = authenticationService.authenticate(request);

        if (authenticatedUser != null) {
            String jwtToken = jwtService.generateToken(authenticatedUser);
            long expiresIn = jwtService.getExpirationTime();

            AuthResponse authResponse = AuthResponse.builder()
                .token(jwtToken)
                .expiresIn(expiresIn)
                .build();
            return ResponseEntity.ok(authResponse);
        }

        // Should ideally not happen if authenticationManager succeeded, but good practice
        return ResponseEntity.status(400).body(null);
    }
}
