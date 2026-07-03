package com.agp.user.service.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.agp.user.service.dto.LoginResponse;
import com.agp.user.service.dto.UserDto;
import com.agp.user.service.entities.Hotel;
import com.agp.user.service.entities.Rating;
import com.agp.user.service.entities.User;
import com.agp.user.service.external.services.HotelService;
import com.agp.user.service.repositories.UserRepositories;
import com.agp.user.service.service.exceptions.ResourceNotFoundException;
import com.agp.user.service.services.UserService;
import com.agp.user.service.util.JwtUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepositories userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private HotelService hotelService;
	// private Logger logger =LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public UserDto saveUser(User user) {
		String randUserId = UUID.randomUUID().toString();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setUserId(randUserId);
		User savedUser = userRepository.save(user);
		new UserDto();
		return UserDto.builder().id(savedUser.getUserId()).username(savedUser.getUserName()).email(savedUser.getEmail())
				.roles(savedUser.getRoles()).build();
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		User user = userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User with Given id is not found on server !!" + userId));
		// http://localhost:8083/ratings/user/54f6dcea-b790-4be5-8f53-246968cb58e8

		Rating[] ratings = restTemplate.getForObject("http://RATING-SERVICE/ratings/user/" + user.getUserId(),
				Rating[].class);
		List<Rating> ratingArray = Arrays.stream(ratings).toList();
		// logger.info("",forObject);

		List<Rating> ratingList = ratingArray.stream().map(rating -> {
			// Using Rest template
			// http://localhost:8082/hotels/4f4db9ca-ed55-463f-82c2-7af32b898a14
			// ResponseEntity<Hotel> forEntity =
			// restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(),
			// Hotel.class);
			// Hotel hotel = forEntity.getBody();

			// Using FiegnClient.
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		user.setRatings(ratingList);

		return user;
	}

	@Override
	public LoginResponse getJwtToken(String userName) {
		String token = jwtUtil.generateToken(userName);
		return LoginResponse.builder().token(token).type("Bearer")
				.valitUntil(jwtUtil.extractExpiration(token).toString()).build();
	}

}
