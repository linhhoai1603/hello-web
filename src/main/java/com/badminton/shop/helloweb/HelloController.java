package com.badminton.shop.helloweb;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @GetMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> root() {
        return ResponseEntity.ok("This is my website to test CI/CD Pipeline, and welcome to my website");
    }

    @GetMapping(path = "/api/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> apiHello() {
        return ResponseEntity.ok(Map.of("message", "Hello my friends, my name is Hoài. This is change by Hoài"));
    }
}

