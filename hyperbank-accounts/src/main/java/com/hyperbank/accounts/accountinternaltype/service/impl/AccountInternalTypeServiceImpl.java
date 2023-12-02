package com.hyperbank.accounts.accountinternaltype.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.accounts.accountinternaltype.entity.AccountInternalType;
import com.hyperbank.accounts.accountinternaltype.mapper.AccountInternalTypeMapper;
import com.hyperbank.accounts.accountinternaltype.repository.AccountInternalTypeRepository;
import com.hyperbank.accounts.accountinternaltype.service.AccountInternalTypeService;

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

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class AccountInternalTypeServiceImpl implements AccountInternalTypeService {

	public AccountInternalTypeServiceImpl(AccountInternalTypeMapper accountInternalTypeMapper, AccountInternalTypeRepository accountInternalTypeRepository) {
		createServiceHelper = new CreateServiceHelperImpl<>(accountInternalTypeRepository, AccountInternalType::getId);
		readServiceHelper = new ReadServiceHelperImpl<>(accountInternalTypeRepository, ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(AccountInternalType.class));
		updateServiceHelper = new UpdateServiceHelperImpl<>(
				accountInternalTypeRepository,
				accountInternalTypeMapper,
				readServiceHelper,
				AccountInternalType::getId);
		deleteServiceHelper = new DeleteServiceHelperImpl<>(accountInternalTypeRepository, readServiceHelper);
	}

	private final CreateServiceHelper<Integer, AccountInternalType> createServiceHelper;
	private final ReadServiceHelper<Integer, AccountInternalType> readServiceHelper;
	private final UpdateServiceHelper<Integer, AccountInternalType> updateServiceHelper;
	private final DeleteServiceHelper<Integer> deleteServiceHelper;

	@Override
	@Transactional(readOnly = true)
	public AccountInternalType getReferenceById(Integer id) {
		return readServiceHelper.getReferenceById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public AccountInternalType findById(Integer id) throws FunctionalException {
		return readServiceHelper.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AccountInternalType> findManyById(Collection<Integer> ids) throws FunctionalException {
		return readServiceHelper.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AccountInternalType> findManyByIdIfPresent(Collection<Integer> ids) {
		return readServiceHelper.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AccountInternalType> findAll() {
		return readServiceHelper.findAll();
	}

	@Override
	public Integer save(AccountInternalType entity) throws FunctionalException {
		return createServiceHelper.save(entity);
	}

	@Override
	public AccountInternalType saveAndReturn(AccountInternalType entity) throws FunctionalException {
		return createServiceHelper.saveAndReturn(entity);
	}

	@Override
	public List<Integer> save(Collection<AccountInternalType> entities) throws FunctionalException {
		return createServiceHelper.save(entities);
	}

	@Override
	public List<AccountInternalType> saveAndReturn(Collection<AccountInternalType> entities) throws FunctionalException {
		return createServiceHelper.saveAndReturn(entities);
	}

	@Override
	public Integer update(AccountInternalType entity) throws FunctionalException {
		return updateServiceHelper.update(entity);
	}

	@Override
	public AccountInternalType updateAndReturn(AccountInternalType entity) throws FunctionalException {
		return updateServiceHelper.updateAndReturn(entity);
	}
	
	@Override
	public List<Integer> update(Collection<AccountInternalType> entities) throws FunctionalException {
		return updateServiceHelper.update(entities);
	}
	
	@Override
	public List<AccountInternalType> updateAndReturn(Collection<AccountInternalType> entities) throws FunctionalException {
		return updateServiceHelper.updateAndReturn(entities);
	}

	@Override
	public void delete(Integer id) throws FunctionalException {
		deleteServiceHelper.delete(id);
	}
	
	@Override
	public void deleteIfPresent(Integer id) {
		deleteServiceHelper.deleteIfPresent(id);
	}

	@Override
	public void deleteMany(Collection<Integer> ids) throws FunctionalException {
		deleteServiceHelper.deleteMany(ids);
	}

	@Override
	public void deleteManyIfPresent(Collection<Integer> ids) {
		deleteServiceHelper.deleteManyIfPresent(ids);
	}
	
}
