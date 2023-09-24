package com.hyperbank.accounts.depositaccountdetails.service;

import java.util.Collection;

import com.hyperbank.accounts.accountinternal.entity.AccountInternal;
import com.hyperbank.accounts.depositaccountdetails.entity.DepositAccountDetails;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.web.service.DeleteService;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;

public interface DepositAccountDetailsService extends ReadService<Long, DepositAccountDetails>, DeleteService<Long> {

	public Long save(AccountInternal accountInternal) throws FunctionalException;

	public DepositAccountDetails saveAndReturn(AccountInternal accountInternal) throws FunctionalException;

	public Collection<Long> save(Collection<AccountInternal> accountsInternal) throws FunctionalException;

	public Collection<DepositAccountDetails> saveAndReturn(Collection<AccountInternal> accountsInternal)  throws FunctionalException;
	
}
