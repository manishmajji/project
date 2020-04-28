package com.cg.service;

import java.time.LocalDate;

import java.time.LocalDateTime;
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
@Transactional
public class BookingService implements IBookingService {

	
	@Autowired
	IBookingDao dao;
	IUniversalDao<Payment> paymentdao;
	
	IUniversalDao<Booking> bookingdao;
	
	IUniversalDao<Ticket> ticketdao;
	
	IUniversalDao<Seat> seatdao;
	
	
	@Override
	public double totalCost(int seatId,int noOfSeats) {
		double seatPrice=dao.getPrice(seatId);
		double totalPrice= noOfSeats*seatPrice;
		
		return totalPrice;
	}
	
	public Payment generatePayment() {
		Payment payment=new Payment();
		payment.setPaymentStatus(false);
		payment.setDate(LocalDateTime.now());
		
		paymentdao.save(payment);
		return payment;
		
	}
	
	
	
	public Payment generatePaymentSuccess(List<Seat> seatstate) {
		Payment payment=new Payment();
		payment.setPaymentStatus(true);
		payment.setDate(LocalDateTime.now());
		payment.setAmount(priceCalculator(seatstate));
		payment.setPaymentType(PaymentType.DEBIT_CARD);
		//ticket.setTicketId(ticketId);
		
		paymentdao.save(payment);
		return payment;
		
	}
	public Booking generateFailedBooking(List<Seat> seats,Show show) {
		Booking b=new Booking();
		b.setSeatList(seats);
		b.setMovie(show.getMovieName());
		b.setShow(show);
		b.setBookingDate(LocalDate.now());
		b.setTotalCost(priceCalculator(seats));
		b.setShowId(show.getShowId());
		Payment p=paymentdao.findById(generatePayment().getId());
		
		//b.setShow(seats[0].);
		b.setTransactionId(p.getId());
		return b;
		
	}
	
	public Booking generateSuccessBooking(List<Seat> seats,Show show) {
		Booking b=new Booking();
		b.setSeatList(seats);
		
		b.setMovie(show.getMovieName());
		b.setShow(show);
		b.setBookingDate(LocalDate.now());
		b.setTotalCost(priceCalculator(seats));
		b.setShowId(show.getShowId());
		Payment p=paymentdao.findById(generatePaymentSuccess(seats).getId());
		b.setTransactionId(p.getId());
		bookingdao.save(b);
		b.setTicket(generateTicket(bookingdao.findById(b.getBookingId()), show, seats));
		bookingdao.update(b);
		return b;
		
	}
	
	public Ticket generateTicket(Booking bookingRef,Show show,List<Seat> seats) {
		Ticket t=new Ticket();
		t.setScreenName(show.getScreenId().getScreenName());
		t.setNoOfSeats(seats.size());
		t.setBookingRef(bookingRef);
		t.setTicketStatus(true);
		ticketdao.save(t);
		return t;
	}
	
	public void CancelBooking(Seat seatstate) {
		seatstate.setSeatStatus(SeatState.AVAILABLE);
		
	}
	
	public double priceCalculator(List<Seat> seats) {
		double price=0;
//		seats.stream().forEach(seat->price=seat.getSeatPrice()+price);
		for (Iterator iterator = seats.iterator(); iterator.hasNext();) {
			Seat seat = (Seat) iterator.next();
			price+=seat.getSeatPrice();
		}
		return price; 
	}
	public void bookSeats(List<Seat> seats) {

//		seats.stream().forEach(seat->price=seat.getSeatPrice()+price);
		for (Iterator iterator = seats.iterator(); iterator.hasNext();) {
			Seat seat = (Seat) iterator.next();
			seat.setSeatStatus(SeatState.BOOKED);
			seatdao.update(seat);
		}
	}

}