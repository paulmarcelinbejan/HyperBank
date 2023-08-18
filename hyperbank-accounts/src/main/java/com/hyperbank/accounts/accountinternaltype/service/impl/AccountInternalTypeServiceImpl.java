package com.hyperbank.accounts.accountinternaltype.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.accounts.accountinternaltype.entity.AccountInternalType;
import com.hyperbank.accounts.accountinternaltype.mapper.AccountInternalTypeMapper;
import com.hyperbank.accounts.accountinternaltype.repository.AccountInternalTypeRepository;
import com.hyperbank.accounts.accountinternaltype.service.AccountInternalTypeService;
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
public class AccountInternalTypeServiceImpl implements AccountInternalTypeService {

	public AccountInternalTypeServiceImpl(AccountInternalTypeMapper accountInternalTypeMapper, AccountInternalTypeRepository accountInternalTypeRepository) {
		createService = new CreateServiceImpl<>(accountInternalTypeRepository, AccountInternalType::getId);
		readService = new ReadServiceImpl<>(accountInternalTypeRepository, ServiceUtils.buildErrorMessageIfEntityNotFoundById(AccountInternalType.class));
		updateService = new UpdateServiceImpl<>(
				accountInternalTypeRepository,
				accountInternalTypeMapper,
				readService,
				AccountInternalType::getId);
		deleteService = new DeleteServiceImpl<>(accountInternalTypeRepository, readService);
	}

	private final CreateService<Integer, AccountInternalType> createService;
	private final ReadService<Integer, AccountInternalType> readService;
	private final UpdateService<Integer, AccountInternalType> updateService;
	private final DeleteService<Integer> deleteService;

	@Override
	@Transactional(readOnly = true)
	public AccountInternalType getReferenceById(Integer id) {
		return readService.getReferenceById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public AccountInternalType findById(Integer id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<AccountInternalType> findManyById(Collection<Integer> ids) throws FunctionalException {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<AccountInternalType> findManyByIdIfPresent(Collection<Integer> ids) {
		return readService.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<AccountInternalType> findAll() {
		return readService.findAll();
	}

	@Override
	public Integer save(AccountInternalType entity) {
		return createService.save(entity);
	}

	@Override
	public AccountInternalType saveAndReturn(AccountInternalType entity) {
		return createService.saveAndReturn(entity);
	}

	@Override
	public Collection<Integer> save(Collection<AccountInternalType> entities) {
		return createService.save(entities);
	}

	@Override
	public Collection<AccountInternalType> saveAndReturn(Collection<AccountInternalType> entities) {
		return createService.saveAndReturn(entities);
	}

	@Override
	public Integer update(AccountInternalType entity) throws FunctionalException {
		return updateService.update(entity);
	}

	@Override
	public AccountInternalType updateAndReturn(AccountInternalType entity) throws FunctionalException {
		return updateService.updateAndReturn(entity);
	}
	
	@Override
	public Collection<Integer> update(Collection<AccountInternalType> entities) throws FunctionalException {
		return updateService.update(entities);
	}
	
	@Override
	public Collection<AccountInternalType> updateAndReturn(Collection<AccountInternalType> entities) throws FunctionalException {
		return updateService.updateAndReturn(entities);
	}

	@Override
	public void delete(Integer id) throws FunctionalException {
		deleteService.delete(id);
	}
	
	@Override
	public void deleteIfPresent(Integer id) {
		deleteService.deleteIfPresent(id);
	}

	@Override
	public void deleteMany(Collection<Integer> ids) throws FunctionalException {
		deleteService.deleteMany(ids);
	}

	@Override
	public void deleteManyIfPresent(Collection<Integer> ids) {
		deleteService.deleteManyIfPresent(ids);
	}
	
}
