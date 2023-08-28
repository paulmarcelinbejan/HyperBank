package com.hyperbank.accounts.depositaccountdetails.service;

import java.util.Collection;

import com.hyperbank.accounts.accountinternal.entity.AccountInternal;
import com.hyperbank.accounts.depositaccountdetails.entity.DepositAccountDetails;
import com.paulmarcelinbejan.toolbox.web.service.DeleteService;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;

public interface DepositAccountDetailsService extends ReadService<Long, DepositAccountDetails>, DeleteService<Long> {

	public Long save(AccountInternal accountInternal);

	public DepositAccountDetails saveAndReturn(AccountInternal accountInternal);

	public Collection<Long> save(Collection<AccountInternal> accountsInternal);

	public Collection<DepositAccountDetails> saveAndReturn(Collection<AccountInternal> accountsInternal);
	
}
