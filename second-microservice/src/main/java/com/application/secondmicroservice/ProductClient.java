package com.application.secondmicroservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@FeignClient(name = "first-microservice")
public interface ProductClient {

    @GetMapping("/api/v1/health")
    Map<String, String> getProductServiceHealth();

    @GetMapping("/api/v1/promotions/freebies")
    List<Object> getEligibleFreebies(@RequestParam("orderTotal") BigDecimal orderTotal);
}