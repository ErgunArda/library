package com.example.application.service.impl;

import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.application.service.IAuthService;
import com.example.config.CustomUserDetails;
import com.example.config.JWTUtils;
import com.example.domain.model.Role;
import com.example.domain.model.User;
import com.example.domain.repository.IUserRepository;
import com.example.dto.AuthResponse;
import com.example.dto.LoginRequest;
import com.example.dto.RegisterRequest;


@Service
public class AuthServiceImpl implements IAuthService{

    private final PasswordEncoder passwordEncoder;
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@Autowired
	private JWTUtils jwtUtils;

    AuthServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
	
	@Override
	public AuthResponse saveUser(RegisterRequest request) {
		User user = new User();
		
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setActiveLoanCount(0);
		user.setPoint(0);
		user.setRole(Role.USER);
		
		AuthResponse authResponse = new AuthResponse();
		BeanUtils.copyProperties(user, authResponse);
		userRepository.saveUser(user);
		return authResponse;
	}

	@Override
	public AuthResponse login(LoginRequest loginRequest) {
		
		String username = loginRequest.getUsername();
		String password = loginRequest.getPassword();
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(username, password));
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
		String token = jwtUtils.generateToken(userDetails);
		
	    User user = ((CustomUserDetails) userDetails).getUser();
	    AuthResponse authResponse = new AuthResponse();
	    
	    BeanUtils.copyProperties(user, authResponse);
	    authResponse.setRole(user.getRole().name());
	    authResponse.setToken(token);
	    
		return authResponse;
	}

}
