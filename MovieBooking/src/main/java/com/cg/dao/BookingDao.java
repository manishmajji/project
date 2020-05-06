package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.entity.Booking;
import com.cg.entity.Seat;

@Repository
@Transactional
public class BookingDao implements IBookingDao,IUniversalDao<Booking> {
	@PersistenceContext
	EntityManager em;
	Seat seat=new Seat();
	/**************************************************************************************************
     *Method:                   getprice
     *description:              fetches the seat price for particular seat
     *@returns                 -seat price
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public double getPrice(int seatId) {
		Seat seatPrice=em.find(Seat.class, seatId);
		return seatPrice.getSeatPrice();
	}
	/**************************************************************************************************
     *Method:                   save
     *description:              saves the booking details
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public void save(Booking entityObject) {
		em.persist(entityObject);
	}
	/**************************************************************************************************
     *Method:                   findById
     *description:              display the paticular record by id
     *bookingId                -fetches the details of that particular id
     *@returns                 -booking details
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Booking findById(Integer id) throws NullPointerException,EntityNotFoundException {
		Booking booking=em.find(Booking.class,id);
		if(booking==null)
		{
			throw new EntityNotFoundException("Booking Not found");
		}
		return booking;
	}
	/**************************************************************************************************
     *Method:                   remove
     *description:              delete the paticular record by id
     *bookingId                -fetches the details of that particular id
     *@returns                 -null
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Booking remove(Integer id) {
		Booking booking=findById(id);
		if(booking!=null)
		{
			em.remove(booking);
		}
		return null;
	}
	/**************************************************************************************************
     *Method:                   remove
     *description:              deletes the booking
     *@returns                 -booking details
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Booking remove(Booking entityObject) {
		 em.remove(entityObject);
		return entityObject;
	}
	/**************************************************************************************************
     *Method:                   update
     *description:              update the paticular record by id
     *bookingId                -fetches the details of that particular id
     *@returns                 -booking details
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Booking update(Integer id, Booking entityObject) {
		Booking bookingid=findById(id);
		if(bookingid==null)
		{
			System.out.println("update error: no such entity exists first save then do this update operation");
			return null;
		}
		return em.merge(entityObject);
	}
	/**************************************************************************************************
     *Method:                   findAll
     *description:              finds all the bookings
     *@returns                 -list of bookings
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public List<Booking> findAll() {
		Query q=em.createQuery("From Booking booking");
		return q.getResultList();
	}
	/**************************************************************************************************
     *Method:                   update
     *description:              update the paticular record by id
     *bookingId                -fetches the details of that particular id
     *@returns                 -booking details
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Booking update(Booking entityObject) {
		Booking booking=findById(entityObject.getBookingId());
		if(booking==null)
		{
			System.out.println("update error: no such entity exists first save then do this update operation");
			return null;
		}
		return em.merge(entityObject);
	}
	/**************************************************************************************************
     *Method:                   saveAndgetId
     *description:              saves and gets particular record
     *@returns                 -bookingId
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	@Transactional
	public Integer saveAndgetId(Booking entityObject) {
		em.persist(entityObject);
		return entityObject.getBookingId();
	}
}
