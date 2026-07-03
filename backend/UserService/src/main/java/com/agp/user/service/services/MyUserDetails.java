package com.agp.user.service.services;

import java.util.Arrays;
import java.util.Collection;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.agp.user.service.entities.User;

public class MyUserDetails implements UserDetails{
	
	private User user;
	
	public MyUserDetails(User user) {
	this.user = user;
	}
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.stream(user.getRoles().split(",")).map(SimpleGrantedAuthority::new).toList();
	}



	@Override
	public @Nullable String getPassword() {
		return user.getPassword();
	}



	@Override
	public String getUsername() {
		return user.getUserName();
	}

}
