package com.hyperbank.accounts.accountinternal.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import io.github.paulmarcelinbejan.toolbox.service.helper.CreateServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.DeleteServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.UpdateServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.impl.CreateServiceHelperImpl;
import io.github.paulmarcelinbejan.toolbox.service.helper.impl.DeleteServiceHelperImpl;
import io.github.paulmarcelinbejan.toolbox.service.helper.impl.ReadServiceHelperImpl;
import io.github.paulmarcelinbejan.toolbox.service.helper.impl.UpdateServiceHelperImpl;
import io.github.paulmarcelinbejan.toolbox.service.helper.utils.ServiceHelperUtils;
import io.github.paulmarcelinbejan.toolbox.utils.text.TextUtils;

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class AccountInternalServiceImpl implements AccountInternalService {

	public AccountInternalServiceImpl(AccountInternalMapper accountInternalMapper, AccountInternalRepository accountInternalRepository, AccountService accountService, final DepositAccountDetailsService depositAccountDetailsService) {
		createServiceHelper = new CreateServiceHelperImpl<>(accountInternalRepository, AccountInternal::getId);
		readServiceHelper = new ReadServiceHelperImpl<>(accountInternalRepository, ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(AccountInternal.class));
		updateServiceHelper = new UpdateServiceHelperImpl<>(
				accountInternalRepository,
				accountInternalMapper,
				readServiceHelper,
				AccountInternal::getId);
		deleteServiceHelper = new DeleteServiceHelperImpl<>(accountInternalRepository, readServiceHelper);
		this.accountService = accountService;
		this.depositAccountDetailsService = depositAccountDetailsService;
	}

	private final CreateServiceHelper<Long, AccountInternal> createServiceHelper;
	private final ReadServiceHelper<Long, AccountInternal> readServiceHelper;
	private final UpdateServiceHelper<Long, AccountInternal> updateServiceHelper;
	private final DeleteServiceHelper<Long> deleteServiceHelper;
	
	private final AccountService accountService;
	private final DepositAccountDetailsService depositAccountDetailsService;
	
	@Override
	@Transactional(readOnly = true)
	public AccountInternal getReferenceById(Long id) {
		return readServiceHelper.getReferenceById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public AccountInternal findById(Long id) throws FunctionalException {
		return readServiceHelper.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AccountInternal> findManyById(Collection<Long> ids) throws FunctionalException {
		return readServiceHelper.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AccountInternal> findManyByIdIfPresent(Collection<Long> ids) {
		return readServiceHelper.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AccountInternal> findAll() {
		return readServiceHelper.findAll();
	}
	
	@Override
	public Long save(AccountInternal entity) throws FunctionalException {
		return saveAndReturn(entity).getId();
	}
	
	@Override
	public AccountInternal saveAndReturn(AccountInternal entity) throws FunctionalException {
		Account account = accountService.saveWithAccountInternalType();
		entity.setAccount(account);
		entity = createServiceHelper.saveAndReturn(entity);
		return entity;
	}

	@Override
	public List<Long> save(Collection<AccountInternal> entities) throws FunctionalException {
		List<Long> savedEntities = new ArrayList<>();
		for(AccountInternal entity : entities) {
			savedEntities.add(save(entity));
		}
		return savedEntities;
	}
	
	@Override
	public List<AccountInternal> saveAndReturn(Collection<AccountInternal> entities) throws FunctionalException {
		List<AccountInternal> savedEntities = new ArrayList<>();
		for(AccountInternal entity : entities) {
			savedEntities.add(saveAndReturn(entity));
		}
		return savedEntities;
	}

	@Override
	public Long update(AccountInternal entity) throws FunctionalException {
		return updateServiceHelper.update(entity);
	}

	@Override
	public AccountInternal updateAndReturn(AccountInternal entity) throws FunctionalException {
		return updateServiceHelper.updateAndReturn(entity);
	}
	
	@Override
	public List<Long> update(Collection<AccountInternal> entities) throws FunctionalException {
		return updateServiceHelper.update(entities);
	}
	
	@Override
	public List<AccountInternal> updateAndReturn(Collection<AccountInternal> entities) throws FunctionalException {
		return updateServiceHelper.updateAndReturn(entities);
	}

	@Override
	public void delete(Long id) throws FunctionalException {
		AccountInternal accountInternal = readServiceHelper.findById(id);
		
		// A Cascade delete will be applied starting from DepositAccountDetails.
		if(TextUtils.isEqualTo(AccountInternalTypeCode.DEPOSIT.name(), accountInternal.getAccountInternalType().getCode())) {
			depositAccountDetailsService.delete(id);
			return;
		}
		
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
