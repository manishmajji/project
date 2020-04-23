package com.cg.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.entity.Seat;



@Repository
public class BookingDao implements IBookingDao{
	@PersistenceContext
	EntityManager entityManager;
	Seat seat=new Seat();
	

	@Override
	public double getPrice(int seatId) {
		
		Seat s1=entityManager.find(Seat.class, seatId);
		if(s1==null)
		{
			// throw new MovieBookingException("seat id is not found"+seatId);
		}
		return s1.getSeatPrice();
	}
	
}
