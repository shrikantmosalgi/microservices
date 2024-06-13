package com.boot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.User;
import com.boot.serviceImpl.UserServiceImpl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@PostMapping("/saveUser")
	public User createUser(@RequestBody User user) {
		
		User user1 =userServiceImpl.saveUser(user);
		return user1;
	}
	
	@GetMapping("/getUser/{userId}")
	@CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")  //this is required when any service is doun
	public User getUser(@PathVariable int userId) {
		User u =userServiceImpl.getUser(userId);
		return u;
	}
	
	//creating fallback method for circuitbreaker
	public User ratingHotelFallback(int userId, Exception ex) {  //return type should be same as calling method
		
		System.out.println("fallback is executed because service is down"+ ex.getMessage());
		User u = new User();
		u.setId(0);
		u.setName("dummy user");
		u.setEmail("dummy@gmail.com");
		return u;
		
	}
	
	
	public List<User> getAllUsers() {
		List<User> users =userServiceImpl.getAllUsers();
		return users;
	}
	
}
