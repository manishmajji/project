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
	/**************************************************************************************************
     *Method:                   save
     *description:              saves the theatre details
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public void save(Theatre entityObject) {
		em.persist(entityObject);
	}
	/**************************************************************************************************
     *Method:                   findById
     *description:              display the paticular record by id
     *theatreId                	-fetches the details of that particular id
     *@returns                 -theatre details
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Theatre findById(Integer id) throws EntityNotFoundException,NullPointerException {
		Theatre theatre= em.find(Theatre.class,id);
		if(theatre==null)
		{
			throw new EntityNotFoundException();
		}
		return theatre;	
	}
	/**************************************************************************************************
     *Method:                   remove
     *description:              delete the paticular record by id
     *theatreId                	-fetches the details of that particular id
     *@returns                 -null
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Theatre remove(Integer id) {
		Theatre theatre=findById(id);
		if(theatre!=null)
		{
			em.remove(theatre);
		}
		return null;
	}
	/**************************************************************************************************
     *Method:                   remove
     *description:              deletes the theatre
     *@returns                 -theatre details
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Theatre remove(Theatre entityObject) {
		em.remove(entityObject);
		return entityObject;
	}
	/**************************************************************************************************
     *Method:                   update
     *description:              update the paticular record by id
     *theatreId                	-fetches the details of that particular id
     *@returns                 -theatre details
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Theatre update(Integer id, Theatre entityObject) {
		Theatre theatre=findById(id);
		if(theatre==null)
		{
			System.out.println("Update error: no such entity exists first save then do this update operation");
			return null;
		}
		return em.merge(entityObject);
	}
	/**************************************************************************************************
     *Method:                   findAll
     *description:              finds all the theatres
     *@returns                 -list of theatres
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public List<Theatre> findAll() {
		Query q=em.createQuery("From Theatre theatre");
		System.out.println(q.getResultList()==null);
		return (List<Theatre>) q.getResultList();
	}
	/**************************************************************************************************
     *Method:                   update
     *description:              update the paticular record by id
     *theatreId                	-fetches the details of that particular id
     *@returns                  -theatre details
     *created by                -Manish
     *created date              -21-APR-2020
     **************************************************************************************************/
	@Override
	public Theatre update(Theatre entityObject) {
		Theatre theatre=findById(entityObject.getTheatreId());
		if(theatre==null)
		{
			System.out.println("update error: no such entity exists first save then do this update operation");
			return null;
		}
		return em.merge(entityObject);
	}
	/**************************************************************************************************
     *Method:                   saveAndgetId
     *description:              saves and gets particular record
     *@returns                 -theatreId
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Integer saveAndgetId(Theatre entityObject) {
		em.persist(entityObject);
		em.flush();
		return entityObject.getTheatreId();
	}



}
