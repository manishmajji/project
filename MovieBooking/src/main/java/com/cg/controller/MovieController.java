package com.cg.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Seat;
import com.cg.entity.Theatre;
import com.cg.entity.Ticket;
import com.cg.exception.MovieBookingException;
import com.cg.service.IBookingService;




@RestController

public class MovieController {
	@Autowired
	IBookingService service;
	
	@PostMapping("/seatfare/{seatId}/{noOfSeats}")
	public double calculateFare(@PathVariable("seatId") int seatId,@PathVariable("noOfSeats") int noOfSeats)
	{
		double totalFare=service.totalCost(seatId,noOfSeats);
		return totalFare;
		//String statement="total cost"+totalFare;
		//return new ResponseEntity<Double>(totalFare,HttpStatus.OK);
	}
	/*
	@GetMapping("/payment"){
		service.generatePaymentSuccess(null);
	}
	
	@GetMapping("/getTicketDetails")
	public List<Ticket> getTicketDetails(@RequestBody Ticket ticket) {
		List<Ticket> ticketDetails=service.getTicketDetails();
		return ticketDetails;
	}
	@GetMapping("/getTheater/{movieId}")
	public List<Theatre> getTheater(@PathVariable("movieId") int movieId) throws MovieBookingException{
		List<Theatre> theaterList =service.getTheater(movieId);
		if(theaterList.isEmpty())
		{
			 throw new MovieBookingException("movie id is not found"+movieId);
		}
		return theaterList;
	}
*/

}
	