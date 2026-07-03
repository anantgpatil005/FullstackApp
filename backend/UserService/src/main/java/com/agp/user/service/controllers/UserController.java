package com.agp.user.service.controllers;

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

import com.agp.user.service.dto.UserDto;
import com.agp.user.service.entities.User;
import com.agp.user.service.services.UserService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody User user) {
		UserDto savedUser = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}
	
	
	int count=1;
	//@CircuitBreaker(name = "USERRATING-BREAKER", fallbackMethod = "ratingHotelFallback")
	//@Retry(name = "USERRATING-BREAKER", fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name = "USERRATING-LIMITER", fallbackMethod = "ratingHotelLimiterFallback")
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSinglrUser(@PathVariable String userId) {
		User user = userService.getUser(userId);
		System.out.println("---------------------------------------:");
		System.out.println("Retry attempt:"+count);
		count = count++;
		return ResponseEntity.ok(user);
	}
	
	
	public ResponseEntity<User> ratingHotelLimiterFallback(String userId, Exception ex) {
		System.out.println("Fallback executed because service is down");
		User user = User.builder().userId("122334")
				.email("dummymail@gmail.com")
				.userName("Dummy")
				.about("dummy desc")
				.build();
		count = 1;
		return new ResponseEntity<>(user, HttpStatus.TOO_MANY_REQUESTS);
	}

	public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex) {
		System.out.println("Fallback executed because service is down");
		User user = User.builder()
				.email("dummymail@gmail.com")
				.userName("Dummy")
				.about("dummy desc")
				.build();
		count = 1;
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		List<User> allUserList = userService.getAllUser();
		return ResponseEntity.ok(allUserList);
	}

}
