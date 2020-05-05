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

	@Override
	public void save(Payment entityObject) {
		// TODO Auto-generated method stub
		em.persist(entityObject);
		
	}

	@Override
	public List<Payment> findAll() {
		// TODO Auto-generated method stub
		Query q=em.createQuery("From Payment payment");
		System.out.println(q.getResultList()==null);
		return (List<Payment>) q.getResultList();
	}

	@Override
	public Payment findById(Integer id) {
		// TODO Auto-generated method stub
		Payment payment= em.find(Payment.class,id);
		if(payment==null)
		{
			throw new EntityNotFoundException();
		}
		return payment;
	}

	@Override
	public Payment remove(Payment entityObject) {
		// TODO Auto-generated method stub
		em.remove(entityObject);
		return entityObject;
		
	}

	@Override
	public Payment remove(Integer id) {
		// TODO Auto-generated method stub
		Payment payment=findById(id);
		if(payment!=null)
		{
			em.remove(payment);
		}
		return null;
		
		
	}

	@Override
	public Payment update(Payment entityObject) {
		// TODO Auto-generated method stub
		Payment payment=findById(entityObject.getId());
		if(payment==null)
		{
			System.out.println("update error: no such entity exists first save then do this update operation");
			return null;
		}
		
		return em.merge(entityObject);
	}

	@Override
	public Payment update(Integer id, Payment entityObject) {
		// TODO Auto-generated method stub
		Payment payment=findById(id);
		if(payment==null)
		{
			System.out.println("Update error: no such entity exists first save then do this update operation");
			return null;
		}
		
		return em.merge(entityObject);
		
	}

}
