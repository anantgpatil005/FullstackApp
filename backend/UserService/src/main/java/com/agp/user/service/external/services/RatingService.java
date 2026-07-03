package com.agp.user.service.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.agp.user.service.entities.Rating;

@Service
@FeignClient(name="RATING-SERVICE")
public interface RatingService {

	//Get
	
	//Post
	@PostMapping("/ratings")
	public Rating createRating(Rating rating);
	
	//Put
	
	@PutMapping("/ratings/{ratingId}")
	public Rating updateRating(String ratingId);
	
	//Delete
	
	@DeleteMapping("/ratings/{ratingId}")
	public void deleteRating(@PathVariable String ratingId);
	
}
