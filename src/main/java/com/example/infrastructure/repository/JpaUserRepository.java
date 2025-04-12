package com.example.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.model.User;
import java.util.List;


public interface JpaUserRepository extends JpaRepository<User, Long>{
	
	public User findByUsername(String username);
}
