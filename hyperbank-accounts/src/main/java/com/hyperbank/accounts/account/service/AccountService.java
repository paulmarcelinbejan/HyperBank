package com.hyperbank.accounts.account.service;

import java.util.Collection;

import com.hyperbank.accounts.account.entity.Account;
import com.hyperbank.accounts.accountexternal.entity.AccountExternal;
import com.hyperbank.accounts.accountinternal.entity.AccountInternal;
import com.paulmarcelinbejan.toolbox.web.service.DeleteService;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;

public interface AccountService extends ReadService<Long, Account>, DeleteService<Long> {

	Long saveForAccountInternal(AccountInternal accountInternal);
	
	Collection<Long> saveManyForAccountInternal(Collection<AccountInternal> accountInternal);
	
	Long saveForAccountExternal(AccountExternal accountExternal);
	
	Collection<Long> saveManyForAccountExternal(Collection<AccountExternal> accountExternal);
	
}
