package com.gastonlagaf.learn.orm.service;

import com.gastonlagaf.learn.orm.annotation.TransactionalOperation;

public interface Service {
	
	@TransactionalOperation
	void performOperation();
	
}
