package com.cg.service;

import java.util.List;

import com.cg.entity.Payment;
import com.cg.entity.Seat;
import com.cg.entity.Theatre;
import com.cg.entity.Ticket;



public interface IBookingService {
	 double totalCost(int seatId,int noOfSeats);
	 Payment generatePaymentSuccess(List<Seat> seatstate);
	
	//public List<User> getUserDetails();
	//public List<Ticket> getTicketDetails();
	//public List<Theatre> getTheater(int movieId);
	

}
