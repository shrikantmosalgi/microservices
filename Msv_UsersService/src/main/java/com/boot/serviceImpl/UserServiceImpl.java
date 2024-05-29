package com.boot.serviceImpl;

import java.util.ArrayList;

import java.util.List;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.boot.entity.Rating;
import com.boot.entity.User;
import com.boot.repository.UserRepository;
import com.boot.service.UserService;

@Service
public class UserServiceImpl implements UserService{	
	
	@Autowired
	private UserRepository userRepository;
	
	// for calling another service methods
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public User saveUser(User user) {

		return	userRepository.save(user);
		 
	}

	@Override
	public List<User> getAllUsers() {
		return	userRepository.findAll();
	}

	@Override
	public User getUser(int userId)  {
		// TODO Auto-generated method stub
		 User user =userRepository.findById(userId).orElseThrow();
		 
		String s = "http://localhost:8083/getUserRating/"+userId;
		 //fetch rating of above user from rating service
		ArrayList<Rating> l= restTemplate.getForObject("http://localhost:8083/getUserRating/"+user.getId(),ArrayList.class);
		user.setRatings(l);
		 return user ;
	}

}
