package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.entity.Customer;
import com.cg.entity.Ticket;

@Repository
@Transactional
public class TicketDao implements IUniversalDao<Ticket> {

	@PersistenceContext
	private EntityManager em;
	/**************************************************************************************************
     *Method:                   save
     *description:              saves the ticket details
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public void save(Ticket entityObject) {
		em.persist(entityObject);
	}
	/**************************************************************************************************
     *Method:                   findById
     *description:              display the paticular record by id
     *ticketId                	-fetches the details of that particular id
     *@returns                 -ticket details
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Ticket findById(Integer id) throws EntityNotFoundException,NullPointerException {
		Ticket ticket= em.find(Ticket.class,id);
		if(ticket==null)
		{
			throw new EntityNotFoundException();
		}
		return ticket;
	}
	/**************************************************************************************************
     *Method:                   remove
     *description:              delete the paticular record by id
     *Id                		-fetches the details of that particular id
     *@returns                 -null
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Ticket remove(Integer id) {
		Ticket ticket=findById(id);
		if(ticket!=null)
		{
			em.remove(ticket);
		}
		return null;
	}
	/**************************************************************************************************
     *Method:                   remove
     *description:              deletes the ticket
     *@returns                 -movie details
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Ticket remove(Ticket entityObject) {
		em.remove(entityObject);
		return entityObject;
	}
	/**************************************************************************************************
     *Method:                   update
     *description:              update the paticular record by id
     *ticketId                	-fetches the details of that particular id
     *@returns                 -ticket details
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Ticket update(Integer id, Ticket entityObject) {
		Ticket ticket=findById(id);
		if(ticket==null)
		{
			System.out.println("Update error: no such entity exists first save then do this update operation");
			return ticket;
		}
		return em.merge(entityObject);
	}
	/**************************************************************************************************
     *Method:                   findAll
     *description:              finds all the tickets
     *@returns                 -list of tickets
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public List<Ticket> findAll() {
		Query q=em.createQuery("From Ticket ticket");
		System.out.println(q.getResultList()==null);
		return (List<Ticket>) q.getResultList();
	}
	/**************************************************************************************************
     *Method:                   update
     *description:              update the paticular record by id
     *ticketId                	-fetches the details of that particular id
     *@returns                  -ticket details
     *created by                -Manish
     *created date              -21-APR-2020
     **************************************************************************************************/
	@Override
	public Ticket update(Ticket entityObject) {
		Ticket ticket=findById(entityObject.getTicketId());
		if(ticket==null)
		{
			System.out.println("update error: no such entity exists first save then do this update operation");
			return null;
		}
		return em.merge(entityObject);
	}
	/**************************************************************************************************
     *Method:                   saveAndgetId
     *description:              saves and gets particular record
     *@returns                 -ticketId
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	@Transactional
	public Integer saveAndgetId(Ticket entityObject) {
		em.persist(entityObject);
		return entityObject.getTicketId();
	}

}