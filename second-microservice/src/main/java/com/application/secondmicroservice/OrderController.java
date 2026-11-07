package com.application.secondmicroservice;
import com.application.secondmicroservice.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    // Plug in the ProductClient "telephone" we made in Step 3
    @Autowired
    private ProductClient productClient;

    // When you visit http://localhost:8083/api/v1/orders/checkout-test in Chrome:
    @GetMapping("/checkout-test")
    public Map<String, Object> testCheckout() {
        Map<String, Object> response = new HashMap<>();
        
        // 1. Add Order Service's own status
        response.put("orderService", "UP");
        
        // 2. Use the telephone to fetch first-microservice's health status!
        response.put("remoteProductServiceCheck", productClient.getProductServiceHealth());
        
        return response;
    }
}
