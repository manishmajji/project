package com.cg.entity;


import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="tickets")
@DynamicInsert

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="ticketId")
public class Ticket {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ticket_id")
	private int ticketId;
	
	@Column(name="no_of_seats")
	private int noOfSeats;
	
	@Column(name="seat_name")
	private String[] seatName;
	
	@OneToOne
	@Autowired
//	@JsonBackReference
	private Booking bookingRef;
	
	@ManyToOne
	@Autowired
//	@JsonBackReference
	private Customer customer;
	
	
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", noOfSeats=" + noOfSeats + ", seatName=" + Arrays.toString(seatName)
				+ ", bookingRef=" + bookingRef + ", customer=" + customer + ", ticketStatus=" + ticketStatus
				+ ", screenName=" + screenName + "]";
	}

	@Column(name="ticket_status")
	private Boolean ticketStatus;
	
	@Column(name="screen_name")
	private String screenName;

	
	
	public Ticket() {
		super();
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public String[] getSeatName() {
		return seatName;
	}

	public void setSeatName(String[] seatName) {
		this.seatName = seatName;
	}

	public Booking getBookingRef() {
		return bookingRef;
	}

	public void setBookingRef(Booking bookingRef) {
		this.bookingRef = bookingRef;
	}

	public Boolean getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(Boolean ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	
}