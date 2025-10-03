package com.user.service;

import java.util.List;
import java.util.Optional;

import com.user.model.User;

public interface UserService {

	public User saveUser(User user);
	
	public List<User> getAllUser();
	
	public User getUser(int userId);
}
