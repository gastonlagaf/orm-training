package com.gastonlagaf.learn.orm.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.gastonlagaf.learn.orm.entity.DomainEntity;
import com.gastonlagaf.learn.orm.manager.EntityManagerProvider;
import com.gastonlagaf.learn.orm.pagination.Page;
import com.gastonlagaf.learn.orm.pagination.PageRequest;
import com.gastonlagaf.pwsf.annotation.Suppress;

public class JpaRepository<T extends DomainEntity<P>, P> implements GenericRepository<T, P> {
	
	private Class<T> type;
	
	public JpaRepository(Class<T> type) {
		this.type = type;
	}
	
	@Suppress
	public P save(T entity) {
		EntityManager em = EntityManagerProvider.retrieve();
		em.persist(entity);
		return entity.getId();
	}
	
	public T findById(P id) {
		EntityManager em = EntityManagerProvider.retrieve();
		return em.find(type, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		EntityManager em = EntityManagerProvider.retrieve();
		Query query = em.createQuery("SELECT t FROM " + type.getName() + " t", type);
		return query.getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	public Page<T> findPage(PageRequest pageRequest) {
		EntityManager em = EntityManagerProvider.retrieve();
		Query countQuery = em.createQuery("SELECT COUNT(t.id) FROM " + type.getName() + " t", Long.class);
		Long totalCount = (Long)countQuery.getSingleResult();
		Query query = em.createQuery("SELECT t FROM " + type.getName() + " t", type);
		query.setFirstResult((pageRequest.getPage() - 1) * pageRequest.getPageCapacity());
		query.setMaxResults(pageRequest.getPageCapacity());
		List<T> content = query.getResultList();
		return new Page<>(content, pageRequest.getPage(), totalCount, new Long(totalCount / pageRequest.getPageCapacity()).intValue());
	}
	
	public void delete(T entity) {
		EntityManager em = EntityManagerProvider.retrieve();
		em.remove(entity);
	}
}
