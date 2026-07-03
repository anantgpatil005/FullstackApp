package com.agp.rating.services;

import java.util.List;

import com.agp.rating.entities.Rating;

public interface RatingService {
	
	//Create
	public Rating saveRating(Rating rating);
	
	//Get Rating by ratingId
	public Rating getRating(String ratingId);
	
	//get All ratings
	public List<Rating> getAll();
	
	//get Rating by User
	public List<Rating> getRatingByUser(String userId);
	
	//get rating by hotel
	public List<Rating> getRatingByHotel(String hotelId);

}
