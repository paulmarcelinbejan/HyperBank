package com.hyperbank.accounts.accountinternal.service;

import com.hyperbank.accounts.accountinternal.entity.AccountInternal;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.web.service.aggregate.CrudService;

public interface AccountInternalService extends CrudService<Long, AccountInternal> {

	AccountInternal findByIBAN(String iban) throws FunctionalException;
	
}
