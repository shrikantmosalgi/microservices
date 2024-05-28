package com.boot.rating.service;

import java.util.List;

import com.boot.rating.entity.Rating;

public interface RatingService {

	public Rating createRating(Rating rating);
	
	public List<Rating> getAllRatings();
	public List<Rating> getRatingByUserId(int userId);
	public List<Rating> getRatingByHotelId(int hotelId);
}
