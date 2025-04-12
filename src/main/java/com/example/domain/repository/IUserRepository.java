package com.example.domain.repository;

import java.util.List;

import com.example.domain.model.User;

public interface IUserRepository {
	public User saveUser(User user);
	public List<User> findAllUsers();
	public User findUserById(Long id);
	public User updateUser(User user , Long id);
	public User findUserByName(String username);
}
