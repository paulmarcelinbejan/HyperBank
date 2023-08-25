package com.hyperbank.accounts.account.service;

import com.hyperbank.accounts.account.entity.Account;
import com.paulmarcelinbejan.toolbox.web.service.DeleteService;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;

public interface AccountService extends ReadService<Long, Account>, DeleteService<Long> {

	Account saveWithAccountInternalType();
	
	Account saveWithAccountExternalType();
	
}
