package com.agp.user.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.agp.user.service.entities.User;
import com.agp.user.service.repositories.UserRepositories;

public class MyUserDetailService  implements UserDetailsService{
	
	@Autowired
	private UserRepositories userRepositories;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		 User user = userRepositories.findByUserName(userName).orElseThrow(()->new  UsernameNotFoundException("User name not found."));
		 return new MyUserDetails(user);
	}

}
