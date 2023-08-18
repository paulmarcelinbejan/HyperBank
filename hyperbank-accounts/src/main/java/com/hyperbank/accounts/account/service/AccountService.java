package com.hyperbank.accounts.account.service;

import com.hyperbank.accounts.account.entity.Account;
import com.hyperbank.accounts.accountexternal.entity.AccountExternal;
import com.hyperbank.accounts.accountinternal.entity.AccountInternal;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;

public interface AccountService extends ReadService<Long, Account> {

	Long save(AccountInternal accountInternal);
	
	Long save(AccountExternal accountExternal);
	
}
