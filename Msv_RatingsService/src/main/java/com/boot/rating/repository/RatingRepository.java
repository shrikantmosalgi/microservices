package com.boot.rating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.rating.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer>{

	List<Rating> findByUserId(int userId);
	List<Rating> findByHotelId(int hotelId);
}
