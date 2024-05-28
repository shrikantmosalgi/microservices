package com.boot.service;

import java.util.List;

import java.util.Optional;

import com.boot.entity.User;

public interface UserService {

	User saveUser(User user);
	
	List<User> getAllUsers();
	
	Optional<User> getUser(int userId);
}
