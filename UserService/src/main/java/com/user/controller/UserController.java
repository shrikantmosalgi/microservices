package com.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		User savedUser =userService.saveUser(user);		
		return ResponseEntity.ok(savedUser);		
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUser(@PathVariable int userId){
		User user =userService.getUser(userId);		
		return ResponseEntity.ok(user);		
	}

	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		
		List<User> userList =userService.getAllUser();
		return ResponseEntity.ok(userList);
		
	}
	
}
