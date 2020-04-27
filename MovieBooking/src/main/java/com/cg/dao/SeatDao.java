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
public class SeatDao implements IUniversalDao<Seat>,ISeatDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(Seat entityObject) {
		// TODO Auto-generated method stub
		em.persist(entityObject);
	}

	@Override
	public Seat findById(Integer id) throws EntityNotFoundException,NullPointerException {
		// TODO Auto-generated method stub
		Seat seat= em.find(Seat.class,id);
		if(seat==null)
		{
			throw new EntityNotFoundException();
		}
		return seat;
	}

	@Override
	public Seat remove(Integer id) {
		// TODO Auto-generated method stub
		Seat seat=findById(id);
		if(seat!=null)
		{
			em.remove(seat);
		}
		return null;
	}

	@Override
	public Seat remove(Seat entityObject) {
		// TODO Auto-generated method stub
		em.remove(entityObject);
		return entityObject;
	}

	@Override
	public Seat update(Integer id, Seat entityObject) {
		// TODO Auto-generated method stub
		Seat seat=findById(id);
		if(seat==null)
		{
			System.out.println("Update error: no such entity exists first save then do this update operation");
			return null;
		}
		
		return em.merge(entityObject);
	}

	@Override
	public List<Seat> findAll() {
		// TODO Auto-generated method stub
		Query q=em.createQuery("From Seat seat");
		System.out.println(q.getResultList()==null);
		return (List<Seat>) q.getResultList();
	}

	@Override
	public Seat update(Seat entityObject) {
		// TODO Auto-generated method stub
		Seat seat=findById(entityObject.getSeatId());
		if(seat==null)
		{
			System.out.println("update error: no such entity exists first save then do this update operation");
			return null;
		}
		
		return em.merge(entityObject);
	}

}
