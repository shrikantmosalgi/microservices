package com.boot.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.boot.entity.Hotel;

@FeignClient(name="MSV-HOTELSSERVICE")
public interface HotelService {

	// here in external service while writing url please write full url not onlt which is in mapping
	@GetMapping("hotel/getHotel/{id}")
	Hotel getHotel(@PathVariable int id);
}
