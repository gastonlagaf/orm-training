package com.gastonlagaf.learn.orm.entitymanager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.gastonlagaf.pwsf.annotation.Suppress;

@Suppress
public class EntityManagerHolder {

	private static EntityManagerFactory entityManagerFactory;
	
	public static EntityManagerFactory getInstance() {
		if(entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("persistenceOracle");
		}
		return entityManagerFactory;
	}
	
}
