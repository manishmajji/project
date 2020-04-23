package com.cg.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.sym.Name;

@Entity
@Table(name="seats")
@DynamicInsert
@DynamicUpdate
public class Seat {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="seat_id")
	private Integer seatId;
	
	@Column(name="seat_price")
	private Double seatPrice;
	
	@Column(name="seat_Status")
	private SeatState seatStatus;

	@ManyToOne(fetch=FetchType.LAZY)
	private Show show;
	
	public Seat() {
		super();
	}
	

	public Seat(double seatPrice, SeatState seatStatus) {
		super();
		this.seatPrice = seatPrice;
		this.seatStatus = seatStatus;
	}



	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public double getSeatPrice() {
		return seatPrice;
	}

	public void setSeatPrice(double seatPrice) {
		this.seatPrice = seatPrice;
	}

	public SeatState getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(SeatState seatStatus) {
		this.seatStatus = seatStatus;
	}
	
	
	
	
	
	

}