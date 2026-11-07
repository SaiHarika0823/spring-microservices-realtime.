package com.application.secondmicroservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Map;

// 1. Look up "first-microservice" inside Eureka Server
@FeignClient(name = "first-microservice")
public interface ProductClient {

    // 2. Call the /api/v1/health URL that you built in ECOMM-101!
    @GetMapping("/api/v1/health")
    Map<String, String> getProductServiceHealth();
}