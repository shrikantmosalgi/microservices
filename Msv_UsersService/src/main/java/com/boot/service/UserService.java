package com.boot.service;

import java.util.List;


import com.boot.entity.User;

public interface UserService {

	User saveUser(User user);
	
	List<User> getAllUsers();
	
	User getUser(int userId);
}
