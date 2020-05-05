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

import com.cg.entity.Ticket;

@Service

public class BookingService implements IBookingService {

	
//	@Autowired
//	IBookingDao dao;
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
	
	public List<Seat> list(List<Seat> seats) {
			//seats = new ArrayList<Seat>();
			seats.add(seatdao.findById(245));
			seats.add(seatdao.findById(246));
			seats.add(seatdao.findById(247));
			//System.out.println(seats.size());
			return seats;
	}
	/*
	public Show showDetails(Show show) {
		
		return show;
		
	}
*/
	public Payment generatePaymentFailed() {
		Payment payment=new Payment();
		payment.setPaymentStatus(false);
		payment.setDate(LocalDateTime.now());
		
		paymentdao.save(payment);
		return payment;
		
	}
	
	public Payment generatePaymentSuccess(List<Seat> seats) {
		
		//seats = new ArrayList<Seat>();
		//list(seats);
		
		Payment payment=new Payment();
		payment.setPaymentStatus(true);
		payment.setDate(LocalDateTime.now());
		payment.setAmount(totalCost(seats));
		payment.setPaymentType(PaymentType.DEBIT_CARD);
		//ticket.setTicketId(ticketId);
		
		paymentdao.save(payment);
		return payment;
		
	}
	public Booking generateFailedBooking(List<Seat> seats) {
		
		//seats = new ArrayList<Seat>();
		seats=list(seats);
		
		Booking b=new Booking();
		b.setSeatList(seats);
		//b.setMovie(show.getMovieName());
		//b.setShow(show);
		b.setBookingDate(LocalDate.now());
		b.setTotalCost(totalCost(seats));
		//b.setShowId(show.getShowId());
		Payment p=paymentdao.findById(generatePaymentFailed().getId());
		
		//b.setShow(seats[0].);
		b.setTransactionId(p.getId());
		return b;
		
	}
	
	@Override
	public Booking generateSuccessBooking(List<Seat> seats) {

		//seats=list(seats);
		
		Booking b=new Booking();
		b.setSeatList(seats);
		
		//b.setMovie(show.getMovieName());
		//b.setShow(show);
		b.setBookingDate(LocalDate.now());
		b.setTotalCost(totalCost(seats));
		//b.setShowId(show.getShowId());
		Payment p=paymentdao.findById(generatePaymentSuccess(seats).getId());
		b.setTransactionId(p.getId());
		bookingdao.save(b);
		b.setTicket(generateTicket(bookingdao.findById(b.getBookingId()), seats));
		bookSeats(seats);
		bookingdao.update(b);
		return b;
		
	}
	
	public Ticket generateTicket(Booking bookingRef,List<Seat> seats) {
		
		seats=list(seats);
		
		Ticket t=new Ticket();
		//t.setScreenName(show.getScreenId().getScreenName());
		t.setNoOfSeats(seats.size());
		t.setBookingRef(bookingRef);
		t.setTicketStatus(true);
		ticketdao.save(t);
		return t;
	}
	
	public void cancelBooking(List<Seat> seats) {
		
		//seats = new ArrayList<Seat>();
		seats=list(seats);		
		for (Iterator iterator = seats.iterator(); iterator.hasNext();) {
			Seat seat = (Seat) iterator.next();
			seat.setSeatStatus(SeatState.AVAILABLE);
			seatdao.update(seat);
		}
		
	}
	
	@Override
	public double totalCost(List<Seat> seats) {
		//seats = new ArrayList<Seat>();
		seats=list(seats);
		double price=0;
//		seats.stream().forEach(seat->price=seat.getSeatPrice()+price);
		for (Iterator iterator = seats.iterator(); iterator.hasNext();) {
			
			Seat seat = (Seat) iterator.next();
			//System.out.println(seat.getSeatPrice());
			price+=seat.getSeatPrice();
		}
		return price; 
	}
	public void bookSeats(List<Seat> seats) {

//		seats.stream().forEach(seat->price=seat.getSeatPrice()+price);
		seats=list(seats);
		for (Iterator iterator = seats.iterator(); iterator.hasNext();) {
			Seat seat = (Seat) iterator.next();
			seat.setSeatStatus(SeatState.BOOKED);
			seatdao.update(seat);
		}
	}
}