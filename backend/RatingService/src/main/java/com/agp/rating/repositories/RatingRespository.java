package com.agp.rating.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.agp.rating.entities.Rating;
import java.util.List;


public interface RatingRespository extends MongoRepository<Rating, String> {

	//Custom finder method
	
	List<Rating> findByUserId(String userId);
	
	List<Rating> findByHotelId(String hotelId);
	
}
