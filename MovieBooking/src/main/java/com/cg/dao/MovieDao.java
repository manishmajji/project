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
	/**************************************************************************************************
     *Method:                   save
     *description:              saves the movie details
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public void save(Movie entityObject) {
		em.persist(entityObject);
		
	}
	/**************************************************************************************************
     *Method:                   findById
     *description:              display the paticular record by id
     *movieId                	-fetches the details of that particular id
     *@returns                 -movie details
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Movie findById(Integer id) throws EntityNotFoundException,NullPointerException{
		Movie movie= em.find(Movie.class,id);
		if(movie==null)
		{
			throw new EntityNotFoundException();
		}
		return movie;
	}
	/**************************************************************************************************
     *Method:                   remove
     *description:              delete the paticular record by id
     *movieId                	-fetches the details of that particular id
     *@returns                 -null
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Movie remove(Integer id) {
		Movie movie=findById(id);
		if(movie!=null)
		{
			em.remove(movie);
		}
		return null;
	}
	/**************************************************************************************************
     *Method:                   remove
     *description:              deletes the movie
     *@returns                 -movie details
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Movie remove(Movie entityObject) {
		em.remove(entityObject);
		return entityObject;
	}
	/**************************************************************************************************
     *Method:                   update
     *description:              update the paticular record by id
     *movieId                	-fetches the details of that particular id
     *@returns                 -movie details
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Movie update(Integer id, Movie entityObject) {
		Movie movie=findById(id);
		if(movie==null)
		{
			System.out.println("Update error: no such entity exists first save then do this update operation");
			return null;
		}
		return em.merge(entityObject);
	}
	/**************************************************************************************************
     *Method:                   findAll
     *description:              finds all the movies
     *@returns                 -list of movies
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public List<Movie> findAll() {
		Query q=em.createQuery("From Movie movie");
		System.out.println(q.getResultList()==null);
		return (List<Movie>) q.getResultList();
	}
	/**************************************************************************************************
     *Method:                   update
     *description:              update the paticular record by id
     *movieId                	-fetches the details of that particular id
     *@returns                  -movie details
     *created by                -Manish
     *created date              -21-APR-2020
     **************************************************************************************************/
	@Override
	public Movie update(Movie entityObject) {
		Movie movie=findById(entityObject.getMovieId());
		if(movie==null)
		{
			System.out.println("update error: no such entity exists first save then do this update operation");
			return null;
		}
		return em.merge(entityObject);
	}
	/**************************************************************************************************
     *Method:                   saveAndgetId
     *description:              saves and gets particular record
     *@returns                 -movieId
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	@Transactional
	public Integer saveAndgetId(Movie entityObject) {
		em.persist(entityObject);
		return entityObject.getMovieId();
	}
}
