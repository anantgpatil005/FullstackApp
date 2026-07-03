package com.agp.user.service.services;

import java.util.List;

import com.agp.user.service.dto.LoginResponse;
import com.agp.user.service.dto.UserDto;
import com.agp.user.service.entities.User;

public interface UserService {
	UserDto saveUser(User user);
	
	List<User> getAllUser();
	
	User getUser(String userId);

	LoginResponse getJwtToken(String userName);

}
