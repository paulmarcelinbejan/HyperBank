package com.hyperbank.accounts.customerindividual.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.accounts.customer.entity.Customer;
import com.hyperbank.accounts.customer.service.CustomerService;
import com.hyperbank.accounts.customerindividual.entity.CustomerIndividual;
import com.hyperbank.accounts.customerindividual.mapper.CustomerIndividualMapper;
import com.hyperbank.accounts.customerindividual.repository.CustomerIndividualRepository;
import com.hyperbank.accounts.customerindividual.service.CustomerIndividualService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.service.helper.CreateServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.DeleteServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.UpdateServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.impl.CreateServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.impl.DeleteServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.impl.ReadServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.impl.UpdateServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.utils.ServiceHelperUtils;

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class CustomerIndividualServiceImpl implements CustomerIndividualService {

	public CustomerIndividualServiceImpl(CustomerIndividualMapper customerIndividualMapper, CustomerIndividualRepository customerIndividualRepository, CustomerService customerService) {
		createServiceHelper = new CreateServiceHelperImpl<>(customerIndividualRepository, CustomerIndividual::getId);
		readServiceHelper = new ReadServiceHelperImpl<>(customerIndividualRepository, ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(CustomerIndividual.class));
		updateServiceHelper = new UpdateServiceHelperImpl<>(
				customerIndividualRepository,
				customerIndividualMapper,
				readServiceHelper,
				CustomerIndividual::getId);
		deleteServiceHelper = new DeleteServiceHelperImpl<>(customerIndividualRepository, readServiceHelper);
		this.customerService = customerService;
	}

	private final CreateServiceHelper<Long, CustomerIndividual> createServiceHelper;
	private final ReadServiceHelper<Long, CustomerIndividual> readServiceHelper;
	private final UpdateServiceHelper<Long, CustomerIndividual> updateServiceHelper;
	private final DeleteServiceHelper<Long> deleteServiceHelper;
	
	private final CustomerService customerService;

	@Override
	@Transactional(readOnly = true)
	public CustomerIndividual getReferenceById(Long id) {
		return readServiceHelper.getReferenceById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public CustomerIndividual findById(Long id) throws FunctionalException {
		return readServiceHelper.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CustomerIndividual> findManyById(Collection<Long> ids) throws FunctionalException {
		return readServiceHelper.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CustomerIndividual> findManyByIdIfPresent(Collection<Long> ids) {
		return readServiceHelper.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CustomerIndividual> findAll() {
		return readServiceHelper.findAll();
	}

	@Override
	public Long save(CustomerIndividual entity) throws FunctionalException {
		return saveAndReturn(entity).getId();
	}
	
	@Override
	public CustomerIndividual saveAndReturn(CustomerIndividual entity) throws FunctionalException {
		Customer customer = customerService.saveWithCustomerIndividualType();
		entity.setCustomer(customer);
		entity = createServiceHelper.saveAndReturn(entity);
		return entity;
	}

	@Override
	public List<Long> save(Collection<CustomerIndividual> entities) throws FunctionalException {
		List<Long> savedEntities = new ArrayList<>();
		for(CustomerIndividual entity : entities) {
			savedEntities.add(save(entity));
		}
		return savedEntities;
	}
	
	@Override
	public List<CustomerIndividual> saveAndReturn(Collection<CustomerIndividual> entities) throws FunctionalException {
		List<CustomerIndividual> savedEntities = new ArrayList<>();
		for(CustomerIndividual entity : entities) {
			savedEntities.add(saveAndReturn(entity));
		}
		return savedEntities;
	}

	@Override
	public Long update(CustomerIndividual entity) throws FunctionalException {
		return updateServiceHelper.update(entity);
	}

	@Override
	public CustomerIndividual updateAndReturn(CustomerIndividual entity) throws FunctionalException {
		return updateServiceHelper.updateAndReturn(entity);
	}
	
	@Override
	public List<Long> update(Collection<CustomerIndividual> entities) throws FunctionalException {
		return updateServiceHelper.update(entities);
	}
	
	@Override
	public List<CustomerIndividual> updateAndReturn(Collection<CustomerIndividual> entities) throws FunctionalException {
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
