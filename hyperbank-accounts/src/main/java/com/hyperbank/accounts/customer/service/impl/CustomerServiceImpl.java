package com.hyperbank.accounts.customer.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.accounts.customer.entity.Customer;
import com.hyperbank.accounts.customer.repository.CustomerRepository;
import com.hyperbank.accounts.customer.service.CustomerService;
import com.hyperbank.accounts.customertype.service.CustomerTypeService;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import io.github.paulmarcelinbejan.toolbox.service.helper.CreateServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.DeleteServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.impl.CreateServiceHelperImpl;
import io.github.paulmarcelinbejan.toolbox.service.helper.impl.DeleteServiceHelperImpl;
import io.github.paulmarcelinbejan.toolbox.service.helper.impl.ReadServiceHelperImpl;
import io.github.paulmarcelinbejan.toolbox.service.helper.utils.ServiceHelperUtils;

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class CustomerServiceImpl implements CustomerService {

	public CustomerServiceImpl(CustomerRepository customerRepository, CustomerTypeService customerTypeService) {
		createServiceHelper = new CreateServiceHelperImpl<>(customerRepository, Customer::getId);
		readServiceHelper = new ReadServiceHelperImpl<>(customerRepository, ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(Customer.class));
		deleteServiceHelper = new DeleteServiceHelperImpl<>(customerRepository, readServiceHelper);
		this.customerTypeService = customerTypeService;
	}

	private final CreateServiceHelper<Long, Customer> createServiceHelper;
	private final ReadServiceHelper<Long, Customer> readServiceHelper;
	private final DeleteServiceHelper<Long> deleteServiceHelper;
	
	private final CustomerTypeService customerTypeService;

	@Override
	@Transactional(readOnly = true)
	public Customer getReferenceById(Long id) {
		return readServiceHelper.getReferenceById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Customer findById(Long id) throws FunctionalException {
		return readServiceHelper.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Customer> findManyById(Collection<Long> ids) throws FunctionalException {
		return readServiceHelper.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Customer> findManyByIdIfPresent(Collection<Long> ids) {
		return readServiceHelper.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Customer> findAll() {
		return readServiceHelper.findAll();
	}

	@Override
	public Customer saveWithCustomerIndividualType() throws FunctionalException {
		Customer customer = new Customer();
		customer.setCustomerType(customerTypeService.getReferenceById(1));
		return createServiceHelper.saveAndReturn(customer);
	}

	@Override
	public Customer saveWithCustomerLegalEntityType() throws FunctionalException {
		Customer customer = new Customer();
		customer.setCustomerType(customerTypeService.getReferenceById(2));
		return createServiceHelper.saveAndReturn(customer);
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
