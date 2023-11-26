package com.hyperbank.accounts.accountnotification.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.accounts.accountnotification.entity.AccountNotification;
import com.hyperbank.accounts.accountnotification.mapper.AccountNotificationMapper;
import com.hyperbank.accounts.accountnotification.repository.AccountNotificationRepository;
import com.hyperbank.accounts.accountnotification.service.AccountNotificationService;
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
public class AccountNotificationServiceImpl implements AccountNotificationService {

	public AccountNotificationServiceImpl(AccountNotificationMapper accountNotificationMapper, AccountNotificationRepository accountNotificationRepository) {
		createServiceHelper = new CreateServiceHelperImpl<>(accountNotificationRepository, AccountNotification::getId);
		readServiceHelper = new ReadServiceHelperImpl<>(accountNotificationRepository, ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(AccountNotification.class));
		deleteServiceHelper = new DeleteServiceHelperImpl<>(accountNotificationRepository, readServiceHelper);
	}

	private final CreateServiceHelper<Long, AccountNotification> createServiceHelper;
	private final ReadServiceHelper<Long, AccountNotification> readServiceHelper;
	private final DeleteServiceHelper<Long> deleteServiceHelper;

	@Override
	@Transactional(readOnly = true)
	public AccountNotification getReferenceById(Long id) {
		return readServiceHelper.getReferenceById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public AccountNotification findById(Long id) throws FunctionalException {
		return readServiceHelper.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AccountNotification> findManyById(Collection<Long> ids) throws FunctionalException {
		return readServiceHelper.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AccountNotification> findManyByIdIfPresent(Collection<Long> ids) {
		return readServiceHelper.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AccountNotification> findAll() {
		return readServiceHelper.findAll();
	}

	@Override
	public Long save(AccountNotification entity) throws FunctionalException {
		return createServiceHelper.save(entity);
	}

	@Override
	public AccountNotification saveAndReturn(AccountNotification entity) throws FunctionalException {
		return createServiceHelper.saveAndReturn(entity);
	}

	@Override
	public List<Long> save(Collection<AccountNotification> entities) throws FunctionalException {
		return createServiceHelper.save(entities);
	}

	@Override
	public List<AccountNotification> saveAndReturn(Collection<AccountNotification> entities) throws FunctionalException {
		return createServiceHelper.saveAndReturn(entities);
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
