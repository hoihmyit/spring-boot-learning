package com.spl.hm.spring_jwt_auth.controller;

import com.spl.hm.spring_jwt_auth.dto.AuthRequest;
import com.spl.hm.spring_jwt_auth.entity.User;
import com.spl.hm.spring_jwt_auth.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
public class AdminController {

    private final UserService userService;

    @PostMapping
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<User> createAdministrator(@RequestBody AuthRequest request) {
        User createdAdmin = userService.createAdministrator(request);

        return ResponseEntity.ok(createdAdmin);
    }
}
