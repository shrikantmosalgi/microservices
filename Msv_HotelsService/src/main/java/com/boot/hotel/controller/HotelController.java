package com.boot.hotel.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.hotel.entity.Hotel;
import com.boot.hotel.service.HotelService;

@RestController
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/createHotel")
	public Hotel createHotel(@RequestBody Hotel hotel){
		return hotelService.createHotel(hotel);
	}
	
	@GetMapping("/getHotel/{id}")
	public Optional<Hotel> getHotel(@PathVariable int id) {
		return hotelService.getHotel(id);
		
	}
	
	
	@GetMapping("/getAllHotel")
	public List<Hotel> getAllHotel(){
		return hotelService.getAllHotel();
	}

}
