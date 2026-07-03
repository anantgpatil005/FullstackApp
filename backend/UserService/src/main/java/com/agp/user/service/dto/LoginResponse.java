package com.agp.user.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class LoginResponse {
	private String token;
	private String type;
	private String valitUntil;
	private String roles;

}
