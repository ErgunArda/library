package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.service.IAuthService;
import com.example.dto.AuthResponse;
import com.example.dto.LoginRequest;
import com.example.dto.RegisterRequest;

@RestController
@RequestMapping("/rest/api/auth")
public class AuthController {
	// LELELELLOLO
	@Autowired
	IAuthService authService;
	
	@PostMapping(path = "/register")
	public AuthResponse userRegister(@RequestBody RegisterRequest registerRequest) {
		
		return authService.saveUser(registerRequest);
	}
	
	@PostMapping(path = "/login")
	public AuthResponse login(@RequestBody LoginRequest loginRequest) {
		
		return authService.login(loginRequest);
	}
}
