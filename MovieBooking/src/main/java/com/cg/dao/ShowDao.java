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
	/**************************************************************************************************
     *Method:                   save
     *description:              saves the show details
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public void save(Show entityObject) {
		em.persist(entityObject);
	}
	/**************************************************************************************************
     *Method:                   findById
     *description:              display the paticular record by id
     *showId                	-fetches the details of that particular id
     *@returns                 -show details
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Show findById(Integer id) throws EntityNotFoundException,NullPointerException{
		Show show= em.find(Show.class,id);
		if(show==null)
		{
			throw new EntityNotFoundException();
		}
		return show;
	}
	/**************************************************************************************************
     *Method:                   remove
     *description:              delete the paticular record by id
     *showId                	-fetches the details of that particular id
     *@returns                 -null
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Show remove(Integer id) {
		Show show=findById(id);
		if(show!=null)
		{
			em.remove(show);
		}
		return null;
	}
	/**************************************************************************************************
     *Method:                   remove
     *description:              deletes the show
     *@returns                 -show details
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Show remove(Show entityObject) {
		em.remove(entityObject);
		return entityObject;
	}
	/**************************************************************************************************
     *Method:                   update
     *description:              update the paticular record by id
     *showId                	-fetches the details of that particular id
     *@returns                 -show details
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Show update(Integer id, Show entityObject) {
		Show show=findById(id);
		if(show==null)
		{
			System.out.println("Update error: no such entity exists first save then do this update operation");
			return null;
		}
		return em.merge(entityObject);
	}
	/**************************************************************************************************
     *Method:                   findAll
     *description:              finds all the shows
     *@returns                 -list of shows
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public List<Show> findAll() {
		Query q=em.createQuery("From Show show");
		System.out.println(q.getResultList()==null);
		return (List<Show>) q.getResultList();
	}
	/**************************************************************************************************
     *Method:                   update
     *description:              update the paticular record by id
     *showId                	-fetches the details of that particular id
     *@returns                  -show details
     *created by                -Manish
     *created date              -21-APR-2020
     **************************************************************************************************/	
	@Override
	public Show update(Show entityObject) {
		Show show=findById(entityObject.getShowId());
		if(show==null)
		{
			System.out.println("update error: no such entity exists first save then do this update operation");
			return null;
		}
		return em.merge(entityObject);
	}
	/**************************************************************************************************
     *Method:                   findActiveShows
     *description:              finds all the active shows
     *showId                	-fetches the details of that particular id
     *@returns                  -show details
     *created by                -Manish
     *created date              -21-APR-2020
     **************************************************************************************************/
	@Override
	public List<Show> findActiveShows() {
		TypedQuery<Show> q= em.createQuery("From Show s where s.showStartTime > :presentTime",Show.class);
		
		return q.setParameter("presentTime",LocalDateTime.now().plusMinutes(45)).getResultList();
	}
	/**************************************************************************************************
     *Method:                   saveAndgetId
     *description:              saves and gets particular record
     *@returns                 -showId
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Integer saveAndgetId(Show entityObject) {
		em.persist(entityObject);
		em.flush();
		return entityObject.getShowId();
	}
}
