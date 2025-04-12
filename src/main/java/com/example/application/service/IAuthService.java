package com.example.application.service;

import com.example.dto.AuthResponse;
import com.example.dto.LoginRequest;
import com.example.dto.RegisterRequest;

public interface IAuthService {
	public AuthResponse saveUser(RegisterRequest request);
	public AuthResponse login(LoginRequest loginRequest);
}
