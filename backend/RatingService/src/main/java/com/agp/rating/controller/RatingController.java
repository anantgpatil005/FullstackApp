package com.agp.rating.controller;

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

import com.agp.rating.entities.Rating;
import com.agp.rating.services.RatingService;


@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	public RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.saveRating(rating));
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getRatings() {
		return ResponseEntity.ok(ratingService.getAll());
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUser(@PathVariable String userId) {
		return ResponseEntity.ok(ratingService.getRatingByUser(userId));
	}
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingsByHotel(@PathVariable String hotelId) {
		return ResponseEntity.ok(ratingService.getRatingByHotel(hotelId));
	}

}
