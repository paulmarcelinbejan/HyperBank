package com.hyperbank.accounts.accountinternal.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.accounts.account.entity.Account;
import com.hyperbank.accounts.account.service.AccountService;
import com.hyperbank.accounts.accountinternal.entity.AccountInternal;
import com.hyperbank.accounts.accountinternal.mapper.AccountInternalMapper;
import com.hyperbank.accounts.accountinternal.repository.AccountInternalRepository;
import com.hyperbank.accounts.accountinternal.service.AccountInternalService;
import com.hyperbank.accounts.accountinternaltype.enums.AccountInternalTypeCode;
import com.hyperbank.accounts.depositaccountdetails.service.DepositAccountDetailsService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.utils.text.TextUtils;
import com.paulmarcelinbejan.toolbox.web.service.CreateService;
import com.paulmarcelinbejan.toolbox.web.service.DeleteService;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;
import com.paulmarcelinbejan.toolbox.web.service.UpdateService;
import com.paulmarcelinbejan.toolbox.web.service.impl.CreateServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.impl.DeleteServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.impl.ReadServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.impl.UpdateServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.utils.ServiceUtils;

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class AccountInternalServiceImpl implements AccountInternalService {

	public AccountInternalServiceImpl(AccountInternalMapper accountInternalMapper, AccountInternalRepository accountInternalRepository, AccountService accountService, final DepositAccountDetailsService depositAccountDetailsService) {
		createService = new CreateServiceImpl<>(accountInternalRepository, AccountInternal::getId);
		readService = new ReadServiceImpl<>(accountInternalRepository, ServiceUtils.buildErrorMessageIfEntityNotFoundById(AccountInternal.class));
		updateService = new UpdateServiceImpl<>(
				accountInternalRepository,
				accountInternalMapper,
				readService,
				AccountInternal::getId);
		deleteService = new DeleteServiceImpl<>(accountInternalRepository, readService);
		this.accountService = accountService;
		this.depositAccountDetailsService = depositAccountDetailsService;
	}

	private final CreateService<Long, AccountInternal> createService;
	private final ReadService<Long, AccountInternal> readService;
	private final UpdateService<Long, AccountInternal> updateService;
	private final DeleteService<Long> deleteService;
	
	private final AccountService accountService;
	private final DepositAccountDetailsService depositAccountDetailsService;
	
	@Override
	@Transactional(readOnly = true)
	public AccountInternal getReferenceById(Long id) {
		return readService.getReferenceById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public AccountInternal findById(Long id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<AccountInternal> findManyById(Collection<Long> ids) throws FunctionalException {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<AccountInternal> findManyByIdIfPresent(Collection<Long> ids) {
		return readService.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<AccountInternal> findAll() {
		return readService.findAll();
	}
	
	@Override
	public Long save(AccountInternal entity) throws FunctionalException {
		return saveAndReturn(entity).getId();
	}
	
	@Override
	public AccountInternal saveAndReturn(AccountInternal entity) throws FunctionalException {
		Account account = accountService.saveWithAccountInternalType();
		entity.setAccount(account);
		entity = createService.saveAndReturn(entity);
		return entity;
	}

	@Override
	public Collection<Long> save(Collection<AccountInternal> entities) throws FunctionalException {
		Collection<Long> savedEntities = new ArrayList<>();
		for(AccountInternal entity : entities) {
			savedEntities.add(save(entity));
		}
		return savedEntities;
	}
	
	@Override
	public Collection<AccountInternal> saveAndReturn(Collection<AccountInternal> entities) throws FunctionalException {
		Collection<AccountInternal> savedEntities = new ArrayList<>();
		for(AccountInternal entity : entities) {
			savedEntities.add(saveAndReturn(entity));
		}
		return savedEntities;
	}

	@Override
	public Long update(AccountInternal entity) throws FunctionalException {
		return updateService.update(entity);
	}

	@Override
	public AccountInternal updateAndReturn(AccountInternal entity) throws FunctionalException {
		return updateService.updateAndReturn(entity);
	}
	
	@Override
	public Collection<Long> update(Collection<AccountInternal> entities) throws FunctionalException {
		return updateService.update(entities);
	}
	
	@Override
	public Collection<AccountInternal> updateAndReturn(Collection<AccountInternal> entities) throws FunctionalException {
		return updateService.updateAndReturn(entities);
	}

	@Override
	public void delete(Long id) throws FunctionalException {
		AccountInternal accountInternal = readService.findById(id);
		
		// A Cascade delete will be applied starting from DepositAccountDetails.
		if(TextUtils.isEqualTo(AccountInternalTypeCode.DEPOSIT.name(), accountInternal.getAccountInternalType().getCode())) {
			depositAccountDetailsService.delete(id);
			return;
		}
		
		deleteService.delete(id);
	}
	
	@Override
	public void deleteIfPresent(Long id) {
		try {
			delete(id);
		} catch (FunctionalException e) { }
	}

	@Override
	public void deleteMany(Collection<Long> ids) throws FunctionalException {
		for(Long id : ids) {
			delete(id);
		}
	}

	@Override
	public void deleteManyIfPresent(Collection<Long> ids) {
		for(Long id : ids) {
			deleteIfPresent(id);
		}
	}
	
}
