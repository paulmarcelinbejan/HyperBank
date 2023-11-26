package com.hyperbank.accounts.accounttype.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.accounts.accounttype.entity.AccountType;
import com.hyperbank.accounts.accounttype.repository.AccountTypeRepository;
import com.hyperbank.accounts.accounttype.service.AccountTypeService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.impl.ReadServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.utils.ServiceHelperUtils;

@Service
@Transactional(readOnly = true, rollbackFor = { FunctionalException.class, TechnicalException.class })
public class AccountTypeServiceImpl implements AccountTypeService {

	public AccountTypeServiceImpl(AccountTypeRepository accountTypeRepository) {
		readServiceHelper = new ReadServiceHelperImpl<>(accountTypeRepository, ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(AccountType.class));
	}

	private final ReadServiceHelper<Integer, AccountType> readServiceHelper;
	
	@Override
	public AccountType getReferenceById(Integer id) {
		return readServiceHelper.getReferenceById(id);
	}
	
	@Override
	public AccountType findById(Integer id) throws FunctionalException {
		return readServiceHelper.findById(id);
	}

	@Override
	public List<AccountType> findManyById(Collection<Integer> ids) throws FunctionalException {
		return readServiceHelper.findManyById(ids);
	}

	@Override
	public List<AccountType> findManyByIdIfPresent(Collection<Integer> ids) {
		return readServiceHelper.findManyByIdIfPresent(ids);
	}

	@Override
	public List<AccountType> findAll() {
		return readServiceHelper.findAll();
	}
	
}
