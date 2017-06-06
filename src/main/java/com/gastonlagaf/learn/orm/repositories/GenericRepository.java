package com.gastonlagaf.learn.orm.repositories;

import java.util.List;

import com.gastonlagaf.learn.orm.pagination.Page;
import com.gastonlagaf.learn.orm.pagination.PageRequest;

public interface GenericRepository<T, P> {

	P save(T entity);
	
	T findById(P id);
	
	List<T> findAll();
	
	Page<T> findPage(PageRequest pageRequest);
	
	void delete(T entity);
	
}
