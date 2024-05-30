package com.boot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.User;
import com.boot.serviceImpl.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@PostMapping("/saveUser")
	public User createUser(@RequestBody User user) {
		
		User user1 =userServiceImpl.saveUser(user);
		return user1;
	}
	
	@GetMapping("/getUser/{userId}")
	public User getUser(@PathVariable int userId) {
		User u =userServiceImpl.getUser(userId);
		return u;
	}
	
	public List<User> getAllUsers() {
		List<User> users =userServiceImpl.getAllUsers();
		return users;
	}
	
}
