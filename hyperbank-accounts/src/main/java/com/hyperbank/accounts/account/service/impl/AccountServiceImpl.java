package com.hyperbank.accounts.account.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.accounts.account.entity.Account;
import com.hyperbank.accounts.account.repository.AccountRepository;
import com.hyperbank.accounts.account.service.AccountService;
import com.hyperbank.accounts.accounttype.service.AccountTypeService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.service.helper.CreateServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.DeleteServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.impl.CreateServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.impl.DeleteServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.impl.ReadServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.utils.ServiceHelperUtils;

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class AccountServiceImpl implements AccountService {

	public AccountServiceImpl(AccountRepository accountRepository, AccountTypeService accountTypeService) {
		createServiceHelper = new CreateServiceHelperImpl<>(accountRepository, Account::getId);
		readServiceHelper = new ReadServiceHelperImpl<>(accountRepository, ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(Account.class));
		deleteServiceHelper = new DeleteServiceHelperImpl<>(accountRepository, readServiceHelper);
		this.accountTypeService = accountTypeService;
	}

	private final CreateServiceHelper<Long, Account> createServiceHelper;
	private final ReadServiceHelper<Long, Account> readServiceHelper;
	private final DeleteServiceHelper<Long> deleteServiceHelper;
	
	private final AccountTypeService accountTypeService;

	@Override
	@Transactional(readOnly = true)
	public Account getReferenceById(Long id) {
		return readServiceHelper.getReferenceById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Account findById(Long id) throws FunctionalException {
		return readServiceHelper.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Account> findManyById(List<Long> ids) throws FunctionalException {
		return readServiceHelper.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Account> findManyByIdIfPresent(List<Long> ids) {
		return readServiceHelper.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Account> findAll() {
		return readServiceHelper.findAll();
	}

	@Override
	public Account saveWithAccountInternalType() throws FunctionalException {
		Account account = new Account();
		account.setAccountType(accountTypeService.getReferenceById(1));
		return createServiceHelper.saveAndReturn(account);
	}
	
	@Override
	public Account saveWithAccountExternalType() throws FunctionalException {
		Account account = new Account();
		account.setAccountType(accountTypeService.getReferenceById(2));
		return createServiceHelper.saveAndReturn(account);
	}

	@Override
	public void delete(Long id) throws FunctionalException {
		deleteServiceHelper.delete(id);
	}

	@Override
	public void deleteIfPresent(Long id) {
		deleteServiceHelper.deleteIfPresent(id);
	}

	@Override
	public void deleteMany(List<Long> ids) throws FunctionalException {
		deleteServiceHelper.deleteMany(ids);
	}

	@Override
	public void deleteManyIfPresent(List<Long> ids) {
		deleteServiceHelper.deleteManyIfPresent(ids);
	}
	
}
