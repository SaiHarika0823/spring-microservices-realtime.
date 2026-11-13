package com.application.secondmicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("/checkout-test")
    public Map<String, Object> testCheckout() {
        Map<String, Object> response = new HashMap<>();
        response.put("orderService", "UP");
        response.put("remoteProductServiceCheck", productClient.getProductServiceHealth());
        return response;
    }

    @GetMapping("/checkout")
    public Map<String, Object> checkoutOrder(@RequestParam("orderTotal") BigDecimal orderTotal) {
        Map<String, Object> orderSummary = new HashMap<>();
        orderSummary.put("orderStatus", "CONFIRMED");
        orderSummary.put("orderTotal", orderTotal);

        List<Object> freebies = productClient.getEligibleFreebies(orderTotal);
        orderSummary.put("appliedFreebies", freebies);
        orderSummary.put("freebieCount", freebies.size());

        return orderSummary;
    }
}