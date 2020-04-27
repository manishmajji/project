package com.cg.dao;

import java.util.List;

import com.cg.entity.Show;


public interface IShowDao {
	
	public List<Show> findActiveShows();
}
