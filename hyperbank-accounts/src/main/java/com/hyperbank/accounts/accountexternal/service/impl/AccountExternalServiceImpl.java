package com.hyperbank.accounts.accountexternal.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.accounts.account.entity.Account;
import com.hyperbank.accounts.account.service.AccountService;
import com.hyperbank.accounts.accountexternal.entity.AccountExternal;
import com.hyperbank.accounts.accountexternal.repository.AccountExternalRepository;
import com.hyperbank.accounts.accountexternal.service.AccountExternalService;
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
public class AccountExternalServiceImpl implements AccountExternalService {

	public AccountExternalServiceImpl(AccountExternalRepository accountExternalRepository, AccountService accountService) {
		createServiceHelper = new CreateServiceHelperImpl<>(accountExternalRepository, AccountExternal::getId);
		readServiceHelper = new ReadServiceHelperImpl<>(accountExternalRepository, ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(AccountExternal.class));
		deleteServiceHelper = new DeleteServiceHelperImpl<>(accountExternalRepository, readServiceHelper);
		this.accountService = accountService;
	}

	private final CreateServiceHelper<Long, AccountExternal> createServiceHelper;
	private final ReadServiceHelper<Long, AccountExternal> readServiceHelper;
	private final DeleteServiceHelper<Long> deleteServiceHelper;
	
	private final AccountService accountService;

	@Override
	@Transactional(readOnly = true)
	public AccountExternal getReferenceById(Long id) {
		return readServiceHelper.getReferenceById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public AccountExternal findById(Long id) throws FunctionalException {
		return readServiceHelper.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AccountExternal> findManyById(Collection<Long> ids) throws FunctionalException {
		return readServiceHelper.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AccountExternal> findManyByIdIfPresent(Collection<Long> ids) {
		return readServiceHelper.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AccountExternal> findAll() {
		return readServiceHelper.findAll();
	}
	
	@Override
	public Long save(AccountExternal entity) throws FunctionalException {
		return saveAndReturn(entity).getId();
	}
	
	@Override
	public AccountExternal saveAndReturn(AccountExternal entity) throws FunctionalException {
		Account account = accountService.saveWithAccountExternalType();
		entity.setAccount(account);
		entity = createServiceHelper.saveAndReturn(entity);
		return entity;
	}

	@Override
	public List<Long> save(Collection<AccountExternal> entities) throws FunctionalException {
		List<Long> savedEntities = new ArrayList<>();
		for(AccountExternal entity : entities) {
			savedEntities.add(save(entity));
		}
		return savedEntities;
	}
	
	@Override
	public List<AccountExternal> saveAndReturn(Collection<AccountExternal> entities) throws FunctionalException {
		List<AccountExternal> savedEntities = new ArrayList<>();
		for(AccountExternal entity : entities) {
			savedEntities.add(saveAndReturn(entity));
		}
		return savedEntities;
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
	public void deleteMany(Collection<Long> ids) throws FunctionalException {
		deleteServiceHelper.deleteMany(ids);
	}

	@Override
	public void deleteManyIfPresent(Collection<Long> ids) {
		deleteServiceHelper.deleteManyIfPresent(ids);
	}
	
}
