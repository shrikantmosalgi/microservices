package com.user.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.model.User;
import com.user.repository.UserRepository;
import com.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		List<User> userList = null;
		
		 userList =userRepository.findAll();
		 
		return userList;
	}

	@Override
	public User getUser(int userId) {
		
		User user =userRepository.findById(userId).orElse(null);
					
		return user;	
	}

	
	
}
