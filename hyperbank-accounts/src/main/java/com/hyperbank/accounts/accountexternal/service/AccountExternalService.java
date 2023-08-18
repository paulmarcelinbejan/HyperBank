package com.hyperbank.accounts.accountexternal.service;

import com.hyperbank.accounts.accountexternal.entity.AccountExternal;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.web.service.aggregate.CrdService;

public interface AccountExternalService extends CrdService<Long, AccountExternal> {

	AccountExternal findByIBAN(String iban) throws FunctionalException;
	
}