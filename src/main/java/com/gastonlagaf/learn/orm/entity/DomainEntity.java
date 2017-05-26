package com.gastonlagaf.learn.orm.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class DomainEntity<P> {
	
	@Id
	@GeneratedValue(generator = "DOMAIN_SEQ", strategy = GenerationType.SEQUENCE)
	private P id;

	public P getId() {
		return id;
	}
	
}
