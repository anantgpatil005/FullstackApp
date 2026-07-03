package com.agp.user.service.util;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	public static String secret = "MyApplicationSecret@54321@MyApplicationSecret@54321@MyApplicationSecret@54321@MyApplicationSecret@54321";
	
	public String generateToken(String userName) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("username", userName);

		return 	Jwts.builder()
		.subject(userName)
		.issuedAt(new Date(System.currentTimeMillis()))
		.expiration(new Date(System.currentTimeMillis()+(1000*60*5)))
		.claims(claims)
		.signWith(getKey())
		.compact();
	}

	private Key getKey() {
		//byte[] bytes =  Base64.getDecoder().decode(secret);
		byte[] bytes = secret.getBytes();
		 return Keys.hmacShaKeyFor(bytes);
	}
	
	private Claims getClaims(String token) {
		return Jwts.parser().verifyWith((SecretKey)getKey())
		.build().parseSignedClaims(token)
		.getPayload();
	}
	
	public Date extractExpiration(String token) {
		return getClaims(token).getExpiration();
	}
}
