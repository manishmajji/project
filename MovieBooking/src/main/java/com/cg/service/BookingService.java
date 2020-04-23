package com.cg.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.IBookingDao;
@Service
@Transactional
public class BookingService implements IBookingService {

	
	@Autowired
	IBookingDao dao;
	@Override
	public double totalCost(int seatId) {
		double seatPrice=dao.getPrice(seatId);
		double totalPrice= seatId*seatPrice;
		
		return totalPrice;
	}

}
