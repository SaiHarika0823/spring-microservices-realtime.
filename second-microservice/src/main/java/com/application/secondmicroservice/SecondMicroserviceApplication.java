package com.application.secondmicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class SecondMicroserviceApplication {

	@Autowired
	private FirstServiceClient firstServiceClient;

	public static void main(String[] args) {
		SpringApplication.run(SecondMicroserviceApplication.class, args);
	}

	@GetMapping("/call-first")
	public String callFirstService() {
		return "Second Microservice calling -> [" + firstServiceClient.getHelloFromFirst() + "]";
	}

	@GetMapping("/call-product")
	public Product callProductService() {
		return firstServiceClient.getProductFromFirst();
	}

}

@FeignClient(name = "FIRST-MICROSERVICE")
interface FirstServiceClient {

	@GetMapping("/hello")
	String getHelloFromFirst();

	@GetMapping("/product-details")
	Product getProductFromFirst();

}