package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.entity.Ticket;



@Repository
@Transactional
public class TicketDao implements IUniversalDao<Ticket> {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void save(Ticket entityObject) {
		// TODO Auto-generated method stub
		em.persist(entityObject);
	}

	@Override
	public Ticket findById(Integer id) throws EntityNotFoundException,NullPointerException {
		// TODO Auto-generated method stub
		Ticket ticket= em.find(Ticket.class,id);
		if(ticket==null)
		{
			throw new EntityNotFoundException();
		}
		return ticket;
	}

	@Override
	public Ticket remove(Integer id) {
		// TODO Auto-generated method stub
		Ticket ticket=findById(id);
		if(ticket!=null)
		{
			em.remove(ticket);
		}
		return null;
	}

	@Override
	public Ticket remove(Ticket entityObject) {
		// TODO Auto-generated method stub
		em.remove(entityObject);
		return entityObject;
	}

	@Override
	public Ticket update(Integer id, Ticket entityObject) {
		// TODO Auto-generated method stub
		Ticket ticket=findById(id);
		if(ticket==null)
		{
			System.out.println("Update error: no such entity exists first save then do this update operation");
			return ticket;
		}
		
		return em.merge(entityObject);
	}

	@Override
	public List<Ticket> findAll() {
		// TODO Auto-generated method stub
		
		Query q=em.createQuery("From Ticket ticket");
		System.out.println(q.getResultList()==null);
		return (List<Ticket>) q.getResultList();
	}

	@Override
	public Ticket update(Ticket entityObject) {
		// TODO Auto-generated method stub
		Ticket ticket=findById(entityObject.getTicketId());
		if(ticket==null)
		{
			System.out.println("update error: no such entity exists first save then do this update operation");
			return null;
		}
		
		return em.merge(entityObject);
	}

}