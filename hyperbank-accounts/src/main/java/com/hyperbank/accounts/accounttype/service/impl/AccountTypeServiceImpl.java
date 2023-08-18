package com.hyperbank.accounts.accounttype.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.accounts.accounttype.entity.AccountType;
import com.hyperbank.accounts.accounttype.repository.AccountTypeRepository;
import com.hyperbank.accounts.accounttype.service.AccountTypeService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;
import com.paulmarcelinbejan.toolbox.web.service.impl.ReadServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.utils.ServiceUtils;

@Service
@Transactional(readOnly = true, rollbackFor = { FunctionalException.class, TechnicalException.class })
public class AccountTypeServiceImpl implements AccountTypeService {

	public AccountTypeServiceImpl(AccountTypeRepository accountTypeRepository) {
		readService = new ReadServiceImpl<>(accountTypeRepository, ServiceUtils.buildErrorMessageIfEntityNotFoundById(AccountType.class));
	}

	private final ReadService<Integer, AccountType> readService;
	
	@Override
	public AccountType getReferenceById(Integer id) {
		return readService.getReferenceById(id);
	}
	
	@Override
	public AccountType findById(Integer id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	public Collection<AccountType> findManyById(Collection<Integer> ids) throws FunctionalException {
		return readService.findManyById(ids);
	}

	@Override
	public Collection<AccountType> findManyByIdIfPresent(Collection<Integer> ids) {
		return readService.findManyByIdIfPresent(ids);
	}

	@Override
	public Collection<AccountType> findAll() {
		return readService.findAll();
	}
	
}
