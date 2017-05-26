package com.gastonlagaf.learn.orm.repositories;

import java.util.List;

public interface GenericRepository<T, P> {

	P save(T entity);
	
	T findById(P id);
	
	List<T> findAll();
	
}
