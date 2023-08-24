package com.hyperbank.accounts.accountinternal.service.impl;

import java.text.MessageFormat;
import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.accounts.account.entity.Account;
import com.hyperbank.accounts.account.service.AccountService;
import com.hyperbank.accounts.accountinternal.entity.AccountInternal;
import com.hyperbank.accounts.accountinternal.mapper.AccountInternalMapper;
import com.hyperbank.accounts.accountinternal.repository.AccountInternalRepository;
import com.hyperbank.accounts.accountinternal.service.AccountInternalService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
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

	public AccountInternalServiceImpl(AccountInternalMapper accountInternalMapper, AccountInternalRepository accountInternalRepository, AccountService accountService) {
		createService = new CreateServiceImpl<>(accountInternalRepository, AccountInternal::getId);
		readService = new ReadServiceImpl<>(accountInternalRepository, ServiceUtils.buildErrorMessageIfEntityNotFoundById(AccountInternal.class));
		updateService = new UpdateServiceImpl<>(
				accountInternalRepository,
				accountInternalMapper,
				readService,
				AccountInternal::getId);
		deleteService = new DeleteServiceImpl<>(accountInternalRepository, readService);
		this.accountInternalRepository = accountInternalRepository;
		this.accountService = accountService;
	}

	private final CreateService<Long, AccountInternal> createService;
	private final ReadService<Long, AccountInternal> readService;
	private final UpdateService<Long, AccountInternal> updateService;
	private final DeleteService<Long> deleteService;
	
	private final AccountInternalRepository accountInternalRepository;
	private final AccountService accountService;

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
	public AccountInternal findByIBAN(String iban) throws FunctionalException {
		return accountInternalRepository
				.findByIban(iban)
				.orElseThrow(() -> new FunctionalException(MessageFormat.format(ServiceUtils.buildErrorMessageIfEntityNotFoundByParameter(AccountInternal.class, "iban"), iban)));
	}
	
	@Override
	public Long save(AccountInternal entity) {
		return saveAndReturn(entity).getId();
	}
	
	@Override
	public AccountInternal saveAndReturn(AccountInternal entity) {
		Account account = accountService.save(entity);
		entity.setAccount(account);
		entity = createService.saveAndReturn(entity);
		return entity;
	}

	@Override
	public Collection<Long> save(Collection<AccountInternal> entities) {
		entities = saveAndReturn(entities);
		return entities.stream()
				       .map(AccountInternal::getId)
				       .toList();
	}
	
	@Override
	public Collection<AccountInternal> saveAndReturn(Collection<AccountInternal> entities) {
		return entities.stream()
					   .map(this::saveAndReturn)
					   .toList();
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
		deleteService.delete(id);
		accountService.delete(id);
	}
	
	@Override
	public void deleteIfPresent(Long id) {
		deleteService.deleteIfPresent(id);
		accountService.deleteIfPresent(id);
	}

	@Override
	public void deleteMany(Collection<Long> ids) throws FunctionalException {
		deleteService.deleteMany(ids);
		accountService.deleteMany(ids);
	}

	@Override
	public void deleteManyIfPresent(Collection<Long> ids) {
		deleteService.deleteManyIfPresent(ids);
		accountService.deleteManyIfPresent(ids);
	}
	
}
