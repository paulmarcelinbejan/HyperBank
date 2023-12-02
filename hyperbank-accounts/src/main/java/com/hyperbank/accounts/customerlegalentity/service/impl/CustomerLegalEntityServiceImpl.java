package com.hyperbank.accounts.customerlegalentity.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.accounts.customer.entity.Customer;
import com.hyperbank.accounts.customer.service.CustomerService;
import com.hyperbank.accounts.customerlegalentity.entity.CustomerLegalEntity;
import com.hyperbank.accounts.customerlegalentity.mapper.CustomerLegalEntityMapper;
import com.hyperbank.accounts.customerlegalentity.repository.CustomerLegalEntityRepository;
import com.hyperbank.accounts.customerlegalentity.service.CustomerLegalEntityService;

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
public class CustomerLegalEntityServiceImpl implements CustomerLegalEntityService {

	public CustomerLegalEntityServiceImpl(CustomerLegalEntityMapper customerLegalEntityMapper, CustomerLegalEntityRepository customerLegalEntityRepository, CustomerService customerService) {
		createServiceHelper = new CreateServiceHelperImpl<>(customerLegalEntityRepository, CustomerLegalEntity::getId);
		readServiceHelper = new ReadServiceHelperImpl<>(customerLegalEntityRepository, ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(CustomerLegalEntity.class));
		updateServiceHelper = new UpdateServiceHelperImpl<>(
				customerLegalEntityRepository,
				customerLegalEntityMapper,
				readServiceHelper,
				CustomerLegalEntity::getId);
		deleteServiceHelper = new DeleteServiceHelperImpl<>(customerLegalEntityRepository, readServiceHelper);
		
		this.customerService = customerService;
	}

	private final CreateServiceHelper<Long, CustomerLegalEntity> createServiceHelper;
	private final ReadServiceHelper<Long, CustomerLegalEntity> readServiceHelper;
	private final UpdateServiceHelper<Long, CustomerLegalEntity> updateServiceHelper;
	private final DeleteServiceHelper<Long> deleteServiceHelper;
	
	private final CustomerService customerService;

	@Override
	@Transactional(readOnly = true)
	public CustomerLegalEntity getReferenceById(Long id) {
		return readServiceHelper.getReferenceById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public CustomerLegalEntity findById(Long id) throws FunctionalException {
		return readServiceHelper.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CustomerLegalEntity> findManyById(Collection<Long> ids) throws FunctionalException {
		return readServiceHelper.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CustomerLegalEntity> findManyByIdIfPresent(Collection<Long> ids) {
		return readServiceHelper.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CustomerLegalEntity> findAll() {
		return readServiceHelper.findAll();
	}
	
	@Override
	public Long save(CustomerLegalEntity entity) throws FunctionalException {
		return saveAndReturn(entity).getId();
	}
	
	@Override
	public CustomerLegalEntity saveAndReturn(CustomerLegalEntity entity) throws FunctionalException {
		Customer customer = customerService.saveWithCustomerLegalEntityType();
		entity.setCustomer(customer);
		entity = createServiceHelper.saveAndReturn(entity);
		return entity;
	}

	@Override
	public List<Long> save(Collection<CustomerLegalEntity> entities) throws FunctionalException {
		List<Long> savedEntities = new ArrayList<>();
		for(CustomerLegalEntity entity : entities) {
			savedEntities.add(save(entity));
		}
		return savedEntities;
	}
	
	@Override
	public List<CustomerLegalEntity> saveAndReturn(Collection<CustomerLegalEntity> entities) throws FunctionalException {
		List<CustomerLegalEntity> savedEntities = new ArrayList<>();
		for(CustomerLegalEntity entity : entities) {
			savedEntities.add(saveAndReturn(entity));
		}
		return savedEntities;
	}

	@Override
	public Long update(CustomerLegalEntity entity) throws FunctionalException {
		return updateServiceHelper.update(entity);
	}

	@Override
	public CustomerLegalEntity updateAndReturn(CustomerLegalEntity entity) throws FunctionalException {
		return updateServiceHelper.updateAndReturn(entity);
	}
	
	@Override
	public List<Long> update(Collection<CustomerLegalEntity> entities) throws FunctionalException {
		return updateServiceHelper.update(entities);
	}
	
	@Override
	public List<CustomerLegalEntity> updateAndReturn(Collection<CustomerLegalEntity> entities) throws FunctionalException {
		return updateServiceHelper.updateAndReturn(entities);
	}
	
	@Override
	public void delete(Long id) throws FunctionalException {
		deleteServiceHelper.delete(id);
		customerService.delete(id);
	}
	
	@Override
	public void deleteIfPresent(Long id) {
		deleteServiceHelper.deleteIfPresent(id);
		customerService.deleteIfPresent(id);
	}

	@Override
	public void deleteMany(Collection<Long> ids) throws FunctionalException {
		deleteServiceHelper.deleteMany(ids);
		customerService.deleteMany(ids);
	}

	@Override
	public void deleteManyIfPresent(Collection<Long> ids) {
		deleteServiceHelper.deleteManyIfPresent(ids);
		customerService.deleteManyIfPresent(ids);
	}
	
}
