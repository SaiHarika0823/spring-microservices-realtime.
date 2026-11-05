package com.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class HealthCheckController {

    @GetMapping("/health")
    public Map<String, String> checkHealth() {
        Map<String, String> status = new HashMap<>();
        status.put("service", "first-microservice");
        status.put("status", "UP");
        status.put("ticket", "ECOMM-101");
        return status;
    }
}