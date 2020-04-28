package com.cg.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.entity.Theatre;



@Repository
@Transactional
public class TheatreDao implements IUniversalDao<Theatre> {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public void save(Theatre entityObject) {
		// TODO Auto-generated method stub
		em.persist(entityObject);
	}

	@Override
	public Theatre findById(Integer id) throws EntityNotFoundException,NullPointerException {
		// TODO Auto-generated method stub
		Theatre theatre= em.find(Theatre.class,id);
		if(theatre==null)
		{
			throw new EntityNotFoundException();
		}
		return theatre;	
	}

	@Override
	public Theatre remove(Integer id) {
		// TODO Auto-generated method stub
		Theatre theatre=findById(id);
		if(theatre!=null)
		{
			em.remove(theatre);
		}
		return null;
	}

	@Override
	public Theatre remove(Theatre entityObject) {
		// TODO Auto-generated method stub
		em.remove(entityObject);
		return entityObject;
	}

	@Override
	public Theatre update(Integer id, Theatre entityObject) {
		// TODO Auto-generated method stub
		Theatre theatre=findById(id);
		if(theatre==null)
		{
			System.out.println("Update error: no such entity exists first save then do this update operation");
			return null;
		}
		
		return em.merge(entityObject);
	}

	@Override
	public List<Theatre> findAll() {
		// TODO Auto-generated method stub
		Query q=em.createQuery("From Theatre theatre");
		System.out.println(q.getResultList()==null);
		return (List<Theatre>) q.getResultList();
	}

	@Override
	public Theatre update(Theatre entityObject) {
		// TODO Auto-generated method stub
		Theatre theatre=findById(entityObject.getTheatreId());
		if(theatre==null)
		{
			System.out.println("update error: no such entity exists first save then do this update operation");
			return null;
		}
		
		return em.merge(entityObject);
	}



}
