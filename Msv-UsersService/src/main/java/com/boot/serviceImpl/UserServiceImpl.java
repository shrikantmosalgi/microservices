package com.boot.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.boot.entity.Hotel;
import com.boot.entity.Rating;
import com.boot.entity.User;
import com.boot.external.service.HotelService;
import com.boot.external.service.RatingService;
import com.boot.repository.UserRepository;
import com.boot.service.UserService;

@Service
public class UserServiceImpl implements UserService{	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	RatingService ratingService;
	
	//fignclient service
	@Autowired
	private HotelService hotelService;     
	
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
		 
		 //fetch rating of above user from rating service
		// Rating[] ratingOfUser= restTemplate.getForObject("http://MSV-RATINGSSERVICE/getUserRating/"+user.getId(),Rating[].class);
		 List<Rating> ratingList =ratingService.getUserRatings(user.getId());  //if not work then uncomment above lune
		 //List<Rating> ratingList =Arrays.stream(ratingOfUser).toList();//convert array to list
		 
		 for(Rating r :ratingList) {
			 
			 //this is using restTemplate
			//Hotel h = restTemplate.getForObject("http://MSV-HOTELSSERVICE/getHotel/"+r.getHotelId(),Hotel.class);
			 
			 // this is using fignclient
			 Hotel h= hotelService.getHotel(r.getHotelId());
			 
			r.setHotel(h);
		 }
		
		user.setRatings(ratingList);
		 return user ;
	}

}
