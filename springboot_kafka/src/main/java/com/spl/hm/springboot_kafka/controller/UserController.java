package com.spl.hm.springboot_kafka.controller;

import com.spl.hm.springboot_kafka.dto.UserMessage;
import com.spl.hm.springboot_kafka.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Logger log = LogManager.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserMessage userMessage) {
        try {
            UserMessage us = userService.saveUser(userMessage);
            log.info("User request processed successfully: {}", userMessage);
            return ResponseEntity.ok("User sent to Kafka with ID: " + userMessage.getId());
        } catch (Exception e) {
            log.error("Failed to process user request: {}", userMessage, e);
            return ResponseEntity.internalServerError().body("Failed to send user to Kafka.");
        }
    }
}
