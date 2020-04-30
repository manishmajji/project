package com.cg.dao;

import java.util.List;

import com.cg.entity.Seat;
import com.cg.entity.Theatre;
import com.cg.entity.Ticket;
import com.cg.entity.User;



public interface IBookingDao {
	public double getPrice(int seatId);
	/*
	public List<User> getUserDetails();
	public List<Ticket> getTicketDetails();
	public List<Theatre> getTheater(int movieId);
	public Seat getSeat(int seatId);
*/
}
