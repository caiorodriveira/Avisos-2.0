package com.avisos.avisos20.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class WelcomeController {
	
	@GetMapping
	public String welcome() {
		return "Welcome to my Spring Boot API";
	}
	
	@GetMapping("/users")
	public String users() {
		return "Authorized user";
	}
	
	@GetMapping("/managers")
	public String managers() {
		return "Authorized manager";
	}

}
