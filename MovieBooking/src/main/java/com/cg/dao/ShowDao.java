package com.cg.dao;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.entity.Show;


@Repository
@Transactional
public class ShowDao implements IUniversalDao<Show>,IShowDao {

	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(Show entityObject) {
		// TODO Auto-generated method stub
		em.persist(entityObject);
	}

	@Override
	public Show findById(Integer id) throws EntityNotFoundException,NullPointerException{
		// TODO Auto-generated method stub
		Show show= em.find(Show.class,id);
		if(show==null)
		{
			throw new EntityNotFoundException();
		}
		return show;
	}

	@Override
	public Show remove(Integer id) {
		// TODO Auto-generated method stub
		Show show=findById(id);
		if(show!=null)
		{
			em.remove(show);
		}
		return null;
	}

	@Override
	public Show remove(Show entityObject) {
		// TODO Auto-generated method stub
		em.remove(entityObject);
		return entityObject;
	}

	@Override
	public Show update(Integer id, Show entityObject) {
		// TODO Auto-generated method stub
		Show show=findById(id);
		if(show==null)
		{
			System.out.println("Update error: no such entity exists first save then do this update operation");
			return null;
		}
		
		return em.merge(entityObject);
	}

	
	@Override
	public List<Show> findAll() {
		// TODO Auto-generated method stub
		Query q=em.createQuery("From Show show");
		System.out.println(q.getResultList()==null);
		return (List<Show>) q.getResultList();
	}

	
	@Override
	public Show update(Show entityObject) {
		// TODO Auto-generated method stub
		Show show=findById(entityObject.getShowId());
		if(show==null)
		{
			System.out.println("update error: no such entity exists first save then do this update operation");
			return null;
		}
		
		return em.merge(entityObject);
	}

	@Override
	public List<Show> findActiveShows() {
		// TODO Auto-generated method stub
		TypedQuery<Show> q= em.createQuery("From Show s where s.showStartTime > :presentTime",Show.class);
		
		return q.setParameter("presentTime",LocalDateTime.now().plusMinutes(45)).getResultList();
	}

}
