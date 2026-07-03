package com.agp.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agp.hotel.entities.Hotel;
import com.agp.hotel.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel savedHotel = hotelService.createHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedHotel);
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getAHotel(@PathVariable String hotelId){
		Hotel hotel = hotelService.getHotel(hotelId);
		return ResponseEntity.status(HttpStatus.OK).body(hotel);
	}
	
	@GetMapping
	public  ResponseEntity<List<Hotel>> getAllHotel(){
		List<Hotel> hotels = hotelService.getHotels();
		return ResponseEntity.status(HttpStatus.OK).body(hotels);
	}
	

}
