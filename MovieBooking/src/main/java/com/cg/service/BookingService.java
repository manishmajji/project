package com.cg.service;

import java.time.LocalDate;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.dao.IBookingDao;
import com.cg.dao.IUniversalDao;

import com.cg.entity.Booking;
import com.cg.entity.Payment;
import com.cg.entity.PaymentType;
import com.cg.entity.Seat;
import com.cg.entity.SeatState;
import com.cg.entity.Show;
import com.cg.entity.Theatre;
import com.cg.entity.Ticket;

@Service

public class BookingService implements IBookingService {

	@Autowired
	IBookingDao dao;
	@Autowired
	IUniversalDao<Payment> paymentdao;
	@Autowired
	IUniversalDao<Booking> bookingdao;
	@Autowired
	IUniversalDao<Ticket> ticketdao;
	@Autowired
	IUniversalDao<Seat> seatdao;
	@Autowired
	IUniversalDao<Show> showdao;
	
	/********************************************************************************************************************
	*       @author           Manish
	*       Description       It is a service used for fetching ticket details by id.
	*       version           1.0
	*       created date      21-APR-2020
	********************************************************************************************************************/
	@Override
	public Ticket ticketDetails(List<Seat> seats) {
		Ticket ticket=ticketdao.findById(555);
		bookSeats(seats);
		return ticket;
	}
	/********************************************************************************************************************
	*       @author           Manish
	*       Description       It is a service used for cancellation of bookings.
	*       version           1.0
	*       created date      21-APR-2020
	********************************************************************************************************************/
	@Override
	public void cancelBooking(List<Seat> seats) {
		seats=list(seats);		
		for (Iterator iterator = seats.iterator(); iterator.hasNext();) {
			Seat seat = (Seat) iterator.next();
			seat.setSeatStatus(SeatState.AVAILABLE);
			seatdao.update(seat);
		}
	}
	/********************************************************************************************************************
	*       @author           Manish
	*       Description       It is a service used for calculating total cost.
	*       version           1.0
	*       created date      21-APR-2020
	********************************************************************************************************************/
	@Override
	public double totalCost(List<Seat> seats) {

		seats=list(seats);
		double price=0;
		for (Iterator iterator = seats.iterator(); iterator.hasNext();) {
			Seat seat = (Seat) iterator.next();
			price+=seat.getSeatPrice();
		}
		return price; 
	}
	public List<Seat> list(List<Seat> seats) {
		seats.add(seatdao.findById(245));
		seats.add(seatdao.findById(246));
		seats.add(seatdao.findById(247));
		return seats;
}
	/********************************************************************************************************************
	*       @author           Manish
	*       Description       It is a service used for converting seat status to booked.
	*       version           1.0
	*       created date      21-APR-2020
	********************************************************************************************************************/
	public void bookSeats(List<Seat> seats) {
		seats=list(seats);
		for (Iterator iterator = seats.iterator(); iterator.hasNext();) {
			Seat seat = (Seat) iterator.next();
			seat.setSeatStatus(SeatState.BOOKED);
			seatdao.update(seat);
		}
	}
}

