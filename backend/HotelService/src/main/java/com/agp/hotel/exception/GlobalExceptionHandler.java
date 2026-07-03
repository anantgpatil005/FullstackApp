package com.agp.hotel.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String,Object>> resourceNotFoundHandler(ResourceNotFoundException ex){
		String message = ex.getMessage();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("status", HttpStatus.NOT_FOUND);
		map.put("message", message);
		map.put("success", false);
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
	
}
