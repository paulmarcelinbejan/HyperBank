package com.hyperbank.accounts.account.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.accounts.account.entity.Account;
import com.hyperbank.accounts.account.repository.AccountRepository;
import com.hyperbank.accounts.account.service.AccountService;
import com.hyperbank.accounts.accounttype.service.AccountTypeService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.web.service.CreateService;
import com.paulmarcelinbejan.toolbox.web.service.DeleteService;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;
import com.paulmarcelinbejan.toolbox.web.service.impl.CreateServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.impl.DeleteServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.impl.ReadServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.utils.ServiceUtils;

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class AccountServiceImpl implements AccountService {

	public AccountServiceImpl(AccountRepository accountRepository, AccountTypeService accountTypeService) {
		createService = new CreateServiceImpl<>(accountRepository, Account::getId);
		readService = new ReadServiceImpl<>(accountRepository, ServiceUtils.buildErrorMessageIfEntityNotFoundById(Account.class));
		deleteService = new DeleteServiceImpl<>(accountRepository, readService);
		this.accountTypeService = accountTypeService;
	}

	private final CreateService<Long, Account> createService;
	private final ReadService<Long, Account> readService;
	private final DeleteService<Long> deleteService;
	
	private final AccountTypeService accountTypeService;

	@Override
	@Transactional(readOnly = true)
	public Account getReferenceById(Long id) {
		return readService.getReferenceById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Account findById(Long id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Account> findManyById(Collection<Long> ids) throws FunctionalException {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Account> findManyByIdIfPresent(Collection<Long> ids) {
		return readService.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Account> findAll() {
		return readService.findAll();
	}

	@Override
	public Account saveWithAccountInternalType() throws FunctionalException {
		Account account = new Account();
		account.setAccountType(accountTypeService.getReferenceById(1));
		return createService.saveAndReturn(account);
	}
	
	@Override
	public Account saveWithAccountExternalType() throws FunctionalException {
		Account account = new Account();
		account.setAccountType(accountTypeService.getReferenceById(2));
		return createService.saveAndReturn(account);
	}

	@Override
	public void delete(Long id) throws FunctionalException {
		deleteService.delete(id);
	}

	@Override
	public void deleteIfPresent(Long id) {
		deleteService.deleteIfPresent(id);
	}

	@Override
	public void deleteMany(Collection<Long> ids) throws FunctionalException {
		deleteService.deleteMany(ids);
	}

	@Override
	public void deleteManyIfPresent(Collection<Long> ids) {
		deleteService.deleteManyIfPresent(ids);
	}
	
}
