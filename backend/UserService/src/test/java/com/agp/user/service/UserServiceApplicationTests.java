package com.agp.user.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.agp.user.service.entities.Rating;
import com.agp.user.service.external.services.RatingService;

@SpringBootTest
class UserServiceApplicationTests {
	
	@Autowired
	private RatingService ratingService;

	@Test
	void contextLoads() {
	}

	@Test
	void createRating() {
		Rating rating = Rating.builder().rating(10).userId("").hotelId("").feedback("Feedback").build();
		
		Rating savedRating = ratingService.createRating(rating);
		
		System.out.println(savedRating.toString());
	}
	
}
