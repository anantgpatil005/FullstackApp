package com.agp.hotel.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agp.hotel.entities.Hotel;
import com.agp.hotel.repositories.HotelRepository;
import com.agp.hotel.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel createHotel(Hotel hotel) {
		String newHotelId = UUID.randomUUID().toString();
		hotel.setId(newHotelId);
		return hotelRepository.save(hotel);
	}

	@Override
	public Hotel getHotel(String hotelId) {
		return hotelRepository.findById(hotelId).orElseThrow(()-> new RuntimeException("Hotel not found"));
	}

	@Override
	public List<Hotel> getHotels() {
		return hotelRepository.findAll();
	}

}
