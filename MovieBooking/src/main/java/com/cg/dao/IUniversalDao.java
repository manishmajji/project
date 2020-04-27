package com.cg.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public interface IUniversalDao<T> {

	@Transactional
	public void save(T entityObject);
	
	@Transactional
	public T findById(Integer id);
	
	@Transactional
	public T remove(Integer id);
	
	@Transactional
	public T remove(T entityObject);
	
	@Transactional
	public T update(Integer id, T entityObject);
	
	@Transactional
	public List<T> findAll();

	@Transactional
	public T update(T entityObject);
	
	
}