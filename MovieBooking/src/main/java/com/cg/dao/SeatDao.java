package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.entity.Seat;

@Repository
@Transactional
public class SeatDao implements IUniversalDao<Seat> {

	@PersistenceContext
	private EntityManager em;
	/**************************************************************************************************
     *Method:                   save
     *description:              saves the seat details
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public void save(Seat entityObject) {
		em.persist(entityObject);
	}
	/**************************************************************************************************
     *Method:                   findById
     *description:              display the paticular record by id
     *seatId                	-fetches the details of that particular id
     *@returns                 -seat details
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Seat findById(Integer id) throws EntityNotFoundException,NullPointerException {
		Seat seat= em.find(Seat.class,id);
		if(seat==null)
		{
			throw new EntityNotFoundException();
		}
		System.out.println(seat.getSeatPrice());
		return seat;
	}
	/**************************************************************************************************
     *Method:                   remove
     *description:              delete the paticular record by id
     *seatId                	-fetches the details of that particular id
     *@returns                 -null
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Seat remove(Integer id) {
		Seat seat=findById(id);
		if(seat!=null)
		{
			em.remove(seat);
		}
		return null;
	}
	/**************************************************************************************************
     *Method:                   remove
     *description:              deletes the seat
     *@returns                 -seat details
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Seat remove(Seat entityObject) {
		em.remove(entityObject);
		return entityObject;
	}
	/**************************************************************************************************
     *Method:                   update
     *description:              update the paticular record by id
     *seatId                	-fetches the details of that particular id
     *@returns                 -seat details
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Seat update(Integer id, Seat entityObject) {
		Seat seat=findById(id);
		if(seat==null)
		{
			System.out.println("Update error: no such entity exists first save then do this update operation");
			return null;
		}
		return em.merge(entityObject);
	}
	/**************************************************************************************************
     *Method:                   findAll
     *description:              finds all the seats
     *@returns                 -list of seats
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public List<Seat> findAll() {
		Query q=em.createQuery("From Seat seat");
		System.out.println(q.getResultList()==null);
		return (List<Seat>) q.getResultList();
	}
	/**************************************************************************************************
     *Method:                   update
     *description:              update the paticular record by id
     *seatId                	-fetches the details of that particular id
     *@returns                  -seat details
     *created by                -Manish
     *created date              -21-APR-2020
     **************************************************************************************************/
	@Override
	public Seat update(Seat entityObject) {
		Seat seat=findById(entityObject.getSeatId());
		if(seat==null)
		{
			System.out.println("update error: no such entity exists first save then do this update operation");
			return null;
		}
		return em.merge(entityObject);
	}
	/**************************************************************************************************
     *Method:                   saveAndgetId
     *description:              saves and gets particular record
     *@returns                 -seatId
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Integer saveAndgetId(Seat entityObject) {
		em.persist(entityObject);
		em.flush();
		return entityObject.getSeatId();
	}
}
