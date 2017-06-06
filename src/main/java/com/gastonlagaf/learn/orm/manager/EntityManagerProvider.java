package com.gastonlagaf.learn.orm.manager;

import java.util.Objects;

import javax.persistence.EntityManager;

import com.gastonlagaf.learn.orm.entitymanager.EntityManagerHolder;

public class EntityManagerProvider {
	
	private static ThreadLocal<EntityManager> threadStorage = new ThreadLocal<>();
	
	public static void put(EntityManager em) {
		threadStorage.set(em);
	}
	
	public static EntityManager retrieve() {
		EntityManager em = threadStorage.get();
		if(Objects.isNull(em)) {
			em = EntityManagerHolder.getInstance().createEntityManager();
		}
		return em;
	}
	
	public static void clear() {
		EntityManager em = threadStorage.get();
		if(Objects.nonNull(em)) {
			threadStorage.remove();
		}
	}
}
