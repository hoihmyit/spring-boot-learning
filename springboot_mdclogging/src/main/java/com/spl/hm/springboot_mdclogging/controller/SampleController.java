package com.spl.hm.springboot_mdclogging.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SampleController {

    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    @GetMapping("/hello")
    public String sayHello(@RequestParam(defaultValue = "World") String name) {
        logger.info("Saying hello to {}", name);
        return "Hello, " + name + "!";
    }

    @PostMapping("/process")
    public String process(@RequestBody String data) {
        logger.info("Received data to process: {}", data);
        return "Processed: " + data;
    }
}
