package com.spl.hm.spring_jwt_auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    // This endpoint requires authentication
    @GetMapping
    public ResponseEntity<String> sayHelloAuthenticated() {
        return ResponseEntity.ok("Hello from authenticated endpoint!");
    }

    // This endpoint requires ADMIN role (linking to RBAC)
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> sayHelloAdmin() {
        return ResponseEntity.ok("Hello from admin endpoint!");
    }
}
