package com.agp.user.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agp.user.service.dto.LoginRequest;
import com.agp.user.service.dto.LoginResponse;
import com.agp.user.service.dto.UserDto;
import com.agp.user.service.entities.User;
import com.agp.user.service.services.UserService;

@RestController
@RequestMapping("/users/authentication")
public class UserAuthenticationController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	
	@PostMapping("/register")
	public  ResponseEntity<UserDto> registerUser(@RequestBody User user){
		UserDto userDto = userService.saveUser(user);
		return new ResponseEntity<>(userDto,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/generate-token")
	public LoginResponse generateLoginResponse(@RequestBody LoginRequest loginRequest) {
		
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		if(authentication.isAuthenticated()) {
			return userService.getJwtToken(loginRequest.getUsername());
		}else {
			throw new RuntimeException("Invalid credentials");
		}
		
	}

}
