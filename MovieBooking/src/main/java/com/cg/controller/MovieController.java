package com.cg.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dao.SeatDao;
import com.cg.entity.Booking;
import com.cg.entity.Seat;

import com.cg.service.IBookingService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {
	@Autowired
	IBookingService service;
	
	@Autowired
	SeatDao dao;
	
	@GetMapping("/seatfare")
	public double calculateFare()
	{
		List<Seat> seats = new ArrayList<Seat>() ;
		double totalFare = service.totalCost(seats);
		return totalFare;
	}
	
	@GetMapping("/paymentfailed")
	public Booking paymentFailed(){
		List<Seat> seats = new ArrayList<Seat>() ;
		//Show show=null; 
		return service.generateFailedBooking(seats);
	}
	
	@GetMapping("/ticketdetails")
	public Booking paymentSuccess(){
		List<Seat> seats = new ArrayList<Seat>() ;
		 
		return service.generateSuccessBooking(seats);
	}
	@GetMapping("/cancelbooking")
	public boolean cancel() {
		List<Seat> seats = new ArrayList<Seat>();
		service.cancelBooking(seats);
		return true;
	}
	/*
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
	