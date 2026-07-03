package com.agp.rating.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agp.rating.entities.Rating;
import com.agp.rating.repositories.RatingRespository;
import com.agp.rating.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRespository ratingRespository;

	@Override
	public Rating saveRating(Rating rating) {
		return ratingRespository.save(rating);
	}

	@Override
	public Rating getRating(String ratingId) {
		return ratingRespository.findById(ratingId).orElseThrow(()-> new RuntimeException("Rating not found!!"));
	}

	@Override
	public List<Rating> getAll() {
		return ratingRespository.findAll();
	}

	@Override
	public List<Rating> getRatingByUser(String userId) {
		return ratingRespository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotel(String hotelId) {
		return ratingRespository.findByHotelId(hotelId);
	}

}
