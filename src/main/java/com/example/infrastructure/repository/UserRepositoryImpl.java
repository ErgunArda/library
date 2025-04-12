package com.example.infrastructure.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.model.User;
import com.example.domain.repository.IUserRepository;

@Repository
public class UserRepositoryImpl implements IUserRepository{
	@Autowired
	JpaUserRepository jpaUserRepository;

	@Override
	public User saveUser(User user) {
		return jpaUserRepository.save(user);
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByName(String username) {
		return jpaUserRepository.findByUsername(username);
	}
}
