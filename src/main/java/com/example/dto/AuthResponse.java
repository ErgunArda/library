package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
	private String username;
	
	private String token;
	
	private String role;
	
	private int point;
	
	private int activeLoanCount;
}
