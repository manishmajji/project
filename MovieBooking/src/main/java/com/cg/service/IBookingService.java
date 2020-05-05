package com.cg.service;

import java.util.List;

import com.cg.entity.Booking;
import com.cg.entity.Payment;
import com.cg.entity.Seat;
import com.cg.entity.Show;
import com.cg.entity.Theatre;
import com.cg.entity.Ticket;



public interface IBookingService {
	 
	 
	//double totalCost(List<Seat> seats);
	double totalCost(List<Seat> seats);
	
	 Booking generateSuccessBooking(List<Seat> seats);
	 
	 Booking generateFailedBooking(List<Seat> seats);
	 void cancelBooking(List<Seat> seats);
	
	//public List<User> getUserDetails();
	//public List<Ticket> getTicketDetails();
	//public List<Theatre> getTheater(int movieId);
	

}
