package com.gastonlagaf.learn.orm.entitymanager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHolder {

	private static EntityManagerFactory entityManagerFactory;
	
	public static EntityManagerFactory getInstance() {
		if(entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("persistenceOracle");
		}
		return entityManagerFactory;
	}
	
}
