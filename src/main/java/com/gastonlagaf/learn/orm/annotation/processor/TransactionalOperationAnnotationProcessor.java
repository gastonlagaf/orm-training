package com.gastonlagaf.learn.orm.annotation.processor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

import javax.persistence.EntityManager;

import com.gastonlagaf.learn.orm.annotation.TransactionalOperation;
import com.gastonlagaf.learn.orm.entitymanager.EntityManagerHolder;
import com.gastonlagaf.learn.orm.manager.EntityManagerProvider;

public class TransactionalOperationAnnotationProcessor<T> implements InvocationHandler {

	private T service;
	
	public TransactionalOperationAnnotationProcessor(T service) {
		super();
		this.service = service;
	}

	@SuppressWarnings("unchecked")
	public static<T> T newInstance(T service, Class<?>... intf) {
		return (T) Proxy.newProxyInstance(service.getClass().getClassLoader(), intf,
				new TransactionalOperationAnnotationProcessor<>(service));
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		TransactionalOperation targetAnnotation = method.getAnnotation(TransactionalOperation.class);
		if(Objects.nonNull(targetAnnotation)) {
			EntityManager em = EntityManagerHolder.getInstance().createEntityManager();
			em.getTransaction().begin();
			EntityManagerProvider.put(em);
			try {
				result = method.invoke(service, args);
				em.getTransaction().commit();
			} catch(Exception e) {
				em.getTransaction().rollback();
			} finally {
				em.close();
			}
			EntityManagerProvider.clear();
		} else {
			result = method.invoke(service);
		}
		return method.getReturnType().cast(result);
	}
	
}
