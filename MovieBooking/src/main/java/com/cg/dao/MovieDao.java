package com.cg.dao;


import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.entity.Movie;



@Repository
@Transactional
public class MovieDao implements IUniversalDao<Movie> {

	@PersistenceContext
	private EntityManager em;
	

	@Override
	public void save(Movie entityObject) {
		// TODO Auto-generated method stub
		em.persist(entityObject);
		
	}

	@Override
	public Movie findById(Integer id) throws EntityNotFoundException,NullPointerException{
		// TODO Auto-generated method stub
		Movie movie= em.find(Movie.class,id);
		if(movie==null)
		{
			throw new EntityNotFoundException();
		}
		return movie;
	}

	@Override
	public Movie remove(Integer id) {
		// TODO Auto-generated method stub
		Movie movie=findById(id);
		if(movie!=null)
		{
			em.remove(movie);
		}
		return null;
	}

	@Override
	public Movie remove(Movie entityObject) {
		// TODO Auto-generated method stub
		em.remove(entityObject);
		return entityObject;
	}

	@Override
	public Movie update(Integer id, Movie entityObject) {
		// TODO Auto-generated method stub
		Movie movie=findById(id);
		if(movie==null)
		{
			System.out.println("Update error: no such entity exists first save then do this update operation");
			return null;
		}
		
		return em.merge(entityObject);
	}

	@Override
	public List<Movie> findAll() {
		// TODO Auto-generated method stub
		
		Query q=em.createQuery("From Movie movie");
		System.out.println(q.getResultList()==null);
		return (List<Movie>) q.getResultList();
	}

	@Override
	public Movie update(Movie entityObject) {
		// TODO Auto-generated method stub
		Movie movie=findById(entityObject.getMovieId());
		if(movie==null)
		{
			System.out.println("update error: no such entity exists first save then do this update operation");
			return null;
		}
		
		return em.merge(entityObject);
	}



}
