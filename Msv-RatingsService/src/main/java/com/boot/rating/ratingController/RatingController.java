package com.boot.rating.ratingController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.rating.entity.Rating;
import com.boot.rating.service.RatingService;

@RestController
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/createRating")
	public Rating createRating(@RequestBody Rating rating) {
		
		return ratingService.createRating(rating);	
	}
	
	@GetMapping("/getAllRatings")
	public List<Rating> getAllRatings(){
		return ratingService.getAllRatings();
		
	}
	
	@GetMapping("/getUserRating/{userId}")
	public List<Rating> getUserRatings(@PathVariable int userId){
		return ratingService.getRatingByUserId(userId);
		
	}
	
	@GetMapping("/getHotelRating/{hotelId}")
	public List<Rating> getHotelRatings(@PathVariable int hotelId){
		return ratingService.getRatingByHotelId(hotelId);
		
	}
	
	
}
