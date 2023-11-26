package com.hyperbank.accounts.account.service;

import com.hyperbank.accounts.account.entity.Account;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.service.helper.DeleteServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;

public interface AccountService extends ReadServiceHelper<Long, Account>, DeleteServiceHelper<Long> {

	Account saveWithAccountInternalType() throws FunctionalException;
	
	Account saveWithAccountExternalType() throws FunctionalException;
	
}
