package com.vetsys.vetsys.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class HealthCheckController {
    @GetMapping("/health")
    public String healthCheck() {
        return "OK👍";
    }
}