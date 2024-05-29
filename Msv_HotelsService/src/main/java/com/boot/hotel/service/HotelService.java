package com.boot.hotel.service;

import java.util.List;

import com.boot.hotel.entity.Hotel;

public interface HotelService {

	public Hotel createHotel(Hotel hotel);
	public List<Hotel> getAllHotel();
	public Hotel getHotel(int id);
}
