package com.boot.serviceImpl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.User;
import com.boot.repository.UserRepository;
import com.boot.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {

		return	userRepository.save(user);
		 
	}

	@Override
	public List<User> getAllUsers() {
		return	userRepository.findAll();
	}

	@Override
	public Optional<User> getUser(int userId)  {
		// TODO Auto-generated method stub
		return userRepository.findById(userId);
	}

}
