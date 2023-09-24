package com.hyperbank.accounts.accountnotification.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.accounts.accountnotification.entity.AccountNotification;
import com.hyperbank.accounts.accountnotification.mapper.AccountNotificationMapper;
import com.hyperbank.accounts.accountnotification.repository.AccountNotificationRepository;
import com.hyperbank.accounts.accountnotification.service.AccountNotificationService;
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
public class AccountNotificationServiceImpl implements AccountNotificationService {

	public AccountNotificationServiceImpl(AccountNotificationMapper accountNotificationMapper, AccountNotificationRepository accountNotificationRepository) {
		createService = new CreateServiceImpl<>(accountNotificationRepository, AccountNotification::getId);
		readService = new ReadServiceImpl<>(accountNotificationRepository, ServiceUtils.buildErrorMessageIfEntityNotFoundById(AccountNotification.class));
		deleteService = new DeleteServiceImpl<>(accountNotificationRepository, readService);
	}

	private final CreateService<Long, AccountNotification> createService;
	private final ReadService<Long, AccountNotification> readService;
	private final DeleteService<Long> deleteService;

	@Override
	@Transactional(readOnly = true)
	public AccountNotification getReferenceById(Long id) {
		return readService.getReferenceById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public AccountNotification findById(Long id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<AccountNotification> findManyById(Collection<Long> ids) throws FunctionalException {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<AccountNotification> findManyByIdIfPresent(Collection<Long> ids) {
		return readService.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<AccountNotification> findAll() {
		return readService.findAll();
	}

	@Override
	public Long save(AccountNotification entity) throws FunctionalException {
		return createService.save(entity);
	}

	@Override
	public AccountNotification saveAndReturn(AccountNotification entity) throws FunctionalException {
		return createService.saveAndReturn(entity);
	}

	@Override
	public Collection<Long> save(Collection<AccountNotification> entities) throws FunctionalException {
		return createService.save(entities);
	}

	@Override
	public Collection<AccountNotification> saveAndReturn(Collection<AccountNotification> entities) throws FunctionalException {
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
