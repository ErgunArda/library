package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.domain.model.User;
import com.example.domain.repository.IUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	IUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {	
		User user = userRepository.findUserByName(username);
		if (user == null) {
		    throw new UsernameNotFoundException("Kullanıcı bulunamadı: " + username);
		}
		return new CustomUserDetails(user);
	}

}
