package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.service.IBookingService;


@RestController

public class MovieController {
	@Autowired
	IBookingService service;
	
	@GetMapping("/seatfare/{seatId}")
	public ResponseEntity<String> calculateFare(@PathVariable("seatId") int seatId)
	{
		double totalFare=service.totalCost(seatId);
		String statement="total cost"+totalFare;
		return new ResponseEntity<String>(statement,HttpStatus.OK);
	}

}
