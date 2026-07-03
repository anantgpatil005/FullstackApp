package com.agp.user.service.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.agp.user.service.entities.Hotel;


@Service
@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
	
	@GetMapping(path="/hotels/{hotelId}")
	public Hotel getHotel(@PathVariable String hotelId);

}
