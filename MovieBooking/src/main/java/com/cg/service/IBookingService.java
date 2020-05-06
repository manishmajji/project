package com.cg.service;

import java.util.List;



import com.cg.entity.Seat;
import com.cg.entity.Theatre;
import com.cg.entity.Ticket;

public interface IBookingService {
	
	public Ticket ticketDetails(List<Seat> seats);
 
	double totalCost(List<Seat> seats);
	
	void cancelBooking(List<Seat> seats);

}
