package com.hyperbank.accounts.customer.service.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.accounts.customer.entity.Customer;
import com.hyperbank.accounts.customer.repository.CustomerRepository;
import com.hyperbank.accounts.customer.service.CustomerService;
import com.hyperbank.accounts.customerindividual.entity.CustomerIndividual;
import com.hyperbank.accounts.customerlegalentity.entity.CustomerLegalEntity;
import com.hyperbank.accounts.customertype.service.CustomerTypeService;
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
public class CustomerServiceImpl implements CustomerService {

	public CustomerServiceImpl(CustomerRepository customerRepository, CustomerTypeService customerTypeService) {
		createService = new CreateServiceImpl<>(customerRepository, Customer::getId);
		readService = new ReadServiceImpl<>(customerRepository, ServiceUtils.buildErrorMessageIfEntityNotFoundById(Customer.class));
		deleteService = new DeleteServiceImpl<>(customerRepository, readService);
		this.customerTypeService = customerTypeService;
	}

	private final CreateService<Long, Customer> createService;
	private final ReadService<Long, Customer> readService;
	private final DeleteService<Long> deleteService;
	
	private final CustomerTypeService customerTypeService;

	@Override
	@Transactional(readOnly = true)
	public Customer getReferenceById(Long id) {
		return readService.getReferenceById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Customer findById(Long id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Customer> findManyById(Collection<Long> ids) throws FunctionalException {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Customer> findManyByIdIfPresent(Collection<Long> ids) {
		return readService.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Customer> findAll() {
		return readService.findAll();
	}

	@Override
	public Long saveForCustomerIndividual(CustomerIndividual customerIndividual) {
		Customer customer = new Customer();
		customer.setCustomerType(customerTypeService.getReferenceById(1));
		customer.setCustomerIndividual(customerIndividual);
		return createService.save(customer);
	}
	
	@Override
	public Collection<Long> saveManyForCustomerIndividual(Collection<CustomerIndividual> customerIndividual) {	
		return customerIndividual.stream().map(this::saveForCustomerIndividual).collect(Collectors.toList());
	}

	@Override
	public Long saveForCustomerLegalEntity(CustomerLegalEntity customerLegalEntity) {
		Customer customer = new Customer();
		customer.setCustomerType(customerTypeService.getReferenceById(2));
		customer.setCustomerLegalEntity(customerLegalEntity);
		return createService.save(customer);
	}
	
	@Override
	public Collection<Long> saveManyForCustomerLegalEntity(Collection<CustomerLegalEntity> customerLegalEntity) {	
		return customerLegalEntity.stream().map(this::saveForCustomerLegalEntity).collect(Collectors.toList());
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
