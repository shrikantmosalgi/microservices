package com.boot.hotel.service;

import java.util.List;
import java.util.Optional;

import com.boot.hotel.entity.Hotel;

public interface HotelService {

	public Hotel createHotel(Hotel hotel);
	public List<Hotel> getAllHotel();
	public Optional<Hotel> getHotel(int id);
}
