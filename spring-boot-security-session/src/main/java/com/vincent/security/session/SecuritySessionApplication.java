package com.vincent.security.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: vincent
 * Date: 2019-01-12 00:28:00
 * Comment:
 */

@SpringBootApplication
@RestController
public class SecuritySessionApplication {

    @GetMapping("/message")
    public ResponseEntity<?> message() {
        return ResponseEntity.ok("success");
    }

    public static void main(String[] args) {
        SpringApplication.run(SecuritySessionApplication.class, args);
    }
}
