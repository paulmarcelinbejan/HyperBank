package com.hyperbank.accounts.depositaccountdetails.service;

import java.util.Collection;

import com.hyperbank.accounts.accountinternal.entity.AccountInternal;
import com.hyperbank.accounts.depositaccountdetails.entity.DepositAccountDetails;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.service.helper.DeleteServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;

public interface DepositAccountDetailsService extends ReadServiceHelper<Long, DepositAccountDetails>, DeleteServiceHelper<Long> {

	public Long save(AccountInternal accountInternal) throws FunctionalException;

	public DepositAccountDetails saveAndReturn(AccountInternal accountInternal) throws FunctionalException;

	public Collection<Long> save(Collection<AccountInternal> accountsInternal) throws FunctionalException;

	public Collection<DepositAccountDetails> saveAndReturn(Collection<AccountInternal> accountsInternal)  throws FunctionalException;
	
}
