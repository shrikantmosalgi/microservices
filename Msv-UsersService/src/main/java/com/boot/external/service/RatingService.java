package com.boot.external.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.boot.entity.Rating;

@FeignClient(name="MSV-RATINGSSERVICE")
public interface RatingService {

	// here in external service while writing url please write full url not onlt which is in mapping

	
	@PostMapping("/rating/createRating")
	Rating createRating(@RequestBody Rating rating);
	
	@GetMapping("/rating/getUserRating/{userId}") 
	List<Rating> getUserRatings(@PathVariable int userId);
	
}