package com.example.userservice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController {
	@GetMapping("/users")
	public String getusers() {
		
		return "User Service is Working";
	}

}
