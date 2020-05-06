package com.cg.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dao.SeatDao;
import com.cg.dao.TicketDao;

import com.cg.entity.Seat;
import com.cg.entity.Theatre;
import com.cg.entity.Ticket;
import com.cg.exception.MovieBookingException;
import com.cg.service.IBookingService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {
	@Autowired
	IBookingService service;
	/**************************************************************************************************
	 *@GetMapping              -Handles HTTP GET requests.
     *created by               -Manish
     *created date             -21-APR-2020
**************************************************************************************************/
	@GetMapping("/seatfare")
	public double calculateFare()
	{
		List<Seat> seats = new ArrayList<Seat>() ;
		double totalFare = service.totalCost(seats);
		return totalFare;
	}
	/**************************************************************************************************
	 *@GetMapping              -Handles HTTP GET requests.
     *created by               -Manish
     *created date             -21-APR-2020
**************************************************************************************************/
	@GetMapping("/ticket")
	@ResponseBody
	public Ticket ticketdetails()
	{
		List<Seat> seats = new ArrayList<Seat>() ;
		return service.ticketDetails(seats);
	}
	/**************************************************************************************************
	 *@GetMapping              -Handles HTTP GET requests.
     *created by               -Manish
     *created date             -21-APR-2020
**************************************************************************************************/
	@GetMapping("/cancelbooking")
	public boolean cancel() {
		List<Seat> seats = new ArrayList<Seat>();
		service.cancelBooking(seats);
		return true;
	}
}
	
