package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.entity.Movie;
import com.cg.entity.Payment;
import com.cg.entity.Show;
@Repository
@Transactional
public class PaymentDao implements IUniversalDao<Payment>{
	@PersistenceContext
	private EntityManager em;
	/**************************************************************************************************
     *Method:                   save
     *description:              saves the payment details
     *@returns                 -payment details
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public void save(Payment entityObject) {
		em.persist(entityObject);
	}
	/**************************************************************************************************
     *Method:                   findAll
     *description:              finds all the payments
     *@returns                 -list of payments
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public List<Payment> findAll() {
		Query q=em.createQuery("From Payment payment");
		System.out.println(q.getResultList()==null);
		return (List<Payment>) q.getResultList();
	}
	/**************************************************************************************************
     *Method:                   findById
     *description:              display the paticular record by id
     *Id                		-fetches the details of that particular id
     *@returns                  -payment details
     *created by                -Manish
     *created date              -21-APR-2020
     **************************************************************************************************/
	@Override
	public Payment findById(Integer id) {
		Payment payment= em.find(Payment.class,id);
		if(payment==null)
		{
			throw new EntityNotFoundException();
		}
		return payment;
	}
	/**************************************************************************************************
     *Method:                   remove
     *description:              deletes the payment
     *@returns                 -payment details
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Payment remove(Payment entityObject) {
		em.remove(entityObject);
		return entityObject;
	}
	/**************************************************************************************************
     *Method:                   remove
     *description:              delete the paticular record by id
     *Id                	-fetches the details of that particular id
     *@returns                 -null
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	public Payment remove(Integer id) {
		Payment payment=findById(id);
		if(payment!=null)
		{
			em.remove(payment);
		}
		return null;
	}
	/**************************************************************************************************
     *Method:                   update
     *description:              update the paticular record by id
     *Id                		-fetches the details of that particular id
     *@returns                  -payment details
     *created by                -Manish
     *created date              -21-APR-2020
     **************************************************************************************************/
	@Override
	public Payment update(Payment entityObject) {
		Payment payment=findById(entityObject.getId());
		if(payment==null)
		{
			System.out.println("update error: no such entity exists first save then do this update operation");
			return null;
		}
		return em.merge(entityObject);
	}
	/**************************************************************************************************
     *Method:                   update
     *description:              update the paticular record by id
     *Id                		-fetches the details of that particular id
     *@returns                  -payment details
     *created by                -Manish
     *created date              -21-APR-2020
     **************************************************************************************************/
	@Override
	public Payment update(Integer id, Payment entityObject) {
		Payment payment=findById(id);
		if(payment==null)
		{
			System.out.println("Update error: no such entity exists first save then do this update operation");
			return null;
		}
		return em.merge(entityObject);
	}
	/**************************************************************************************************
     *Method:                   saveAndgetId
     *description:              saves and gets particular record
     *@returns                 -Id
     *created by               -Manish
     *created date             -21-APR-2020
     **************************************************************************************************/
	@Override
	@Transactional
	public Integer saveAndgetId(Payment entityObject) {
		em.persist(entityObject);
		return entityObject.getId();
	}
}
