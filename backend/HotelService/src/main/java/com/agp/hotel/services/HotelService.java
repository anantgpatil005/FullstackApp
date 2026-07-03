package com.agp.hotel.services;

import java.util.List;

import com.agp.hotel.entities.Hotel;

public interface HotelService {

	public Hotel createHotel(Hotel hotel);
	
	public Hotel getHotel(String hotelId);

	public List<Hotel> getHotels();
}
