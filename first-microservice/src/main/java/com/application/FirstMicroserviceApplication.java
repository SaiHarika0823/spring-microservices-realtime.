package com.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class FirstMicroserviceApplication implements CommandLineRunner {
	
@Autowired
private ProductRepository productrepository;
@Override
public void run(String ...args) throws Exception{
	productrepository.save(new Product(null,"gaming laptop",23654));
}


	public static void main(String[] args) {
		SpringApplication.run(FirstMicroserviceApplication.class, args);
		
	}

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello from First Microservice!";
	}

	@GetMapping("/product-details")
	public Product getproductdetails() {
		return productrepository.findById(1L).orElse(null);

}
	
}


