package com.hyperbank.accounts.accountexternal.service.impl;

import java.text.MessageFormat;
import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.accounts.accountexternal.entity.AccountExternal;
import com.hyperbank.accounts.accountexternal.repository.AccountExternalRepository;
import com.hyperbank.accounts.accountexternal.service.AccountExternalService;
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
public class AccountExternalServiceImpl implements AccountExternalService {

	public AccountExternalServiceImpl(AccountExternalRepository accountExternalRepository) {
		createService = new CreateServiceImpl<>(accountExternalRepository, AccountExternal::getId);
		readService = new ReadServiceImpl<>(accountExternalRepository, ServiceUtils.buildErrorMessageIfEntityNotFoundById(AccountExternal.class));
		deleteService = new DeleteServiceImpl<>(accountExternalRepository, readService);
		this.accountExternalRepository = accountExternalRepository;
	}

	private final CreateService<Long, AccountExternal> createService;
	private final ReadService<Long, AccountExternal> readService;
	private final DeleteService<Long> deleteService;
	
	private final AccountExternalRepository accountExternalRepository;

	@Override
	@Transactional(readOnly = true)
	public AccountExternal getReferenceById(Long id) {
		return readService.getReferenceById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public AccountExternal findById(Long id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<AccountExternal> findManyById(Collection<Long> ids) throws FunctionalException {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<AccountExternal> findManyByIdIfPresent(Collection<Long> ids) {
		return readService.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<AccountExternal> findAll() {
		return readService.findAll();
	}
	
	@Override
	public AccountExternal findByIBAN(String iban) throws FunctionalException {
		return accountExternalRepository
				.findByIban(iban)
				.orElseThrow(() -> new FunctionalException(MessageFormat.format(ServiceUtils.buildErrorMessageIfEntityNotFoundByParameter(AccountExternal.class, "iban"), iban)));
	}

	@Override
	public Long save(AccountExternal entity) {
		return createService.save(entity);
	}
	
	@Override
	public AccountExternal saveAndReturn(AccountExternal entity) {
		return createService.saveAndReturn(entity);
	}

	@Override
	public Collection<Long> save(Collection<AccountExternal> entities) {
		return createService.save(entities);
	}
	
	@Override
	public Collection<AccountExternal> saveAndReturn(Collection<AccountExternal> entities) {
		return createService.saveAndReturn(entities);
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
