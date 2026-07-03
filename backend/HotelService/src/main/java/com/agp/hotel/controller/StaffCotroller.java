package com.agp.hotel.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
public class StaffCotroller {

	@GetMapping
	public ResponseEntity<List<String>> getStaff(){
		List<String> stafList = Arrays.asList("Shyam","Ram","Ramesh","Suresh") ;
		return new ResponseEntity<>(stafList,HttpStatus.OK);
	}
}
