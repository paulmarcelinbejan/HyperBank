package com.hyperbank.accounts.customertype.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.accounts.customertype.entity.CustomerType;
import com.hyperbank.accounts.customertype.repository.CustomerTypeRepository;
import com.hyperbank.accounts.customertype.service.CustomerTypeService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;
import com.paulmarcelinbejan.toolbox.web.service.impl.ReadServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.utils.ServiceUtils;

@Service
@Transactional(readOnly = true, rollbackFor = { FunctionalException.class, TechnicalException.class })
public class CustomerTypeServiceImpl implements CustomerTypeService {

	public CustomerTypeServiceImpl(CustomerTypeRepository customerTypeRepository) {
		readService = new ReadServiceImpl<>(customerTypeRepository, ServiceUtils.buildErrorMessageIfEntityNotFoundById(CustomerType.class));
	}

	private final ReadService<Integer, CustomerType> readService;
	
	@Override
	public CustomerType getReferenceById(Integer id) {
		return readService.getReferenceById(id);
	}
	
	@Override
	public CustomerType findById(Integer id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	public Collection<CustomerType> findManyById(Collection<Integer> ids) throws FunctionalException {
		return readService.findManyById(ids);
	}

	@Override
	public Collection<CustomerType> findManyByIdIfPresent(Collection<Integer> ids) {
		return readService.findManyByIdIfPresent(ids);
	}

	@Override
	public Collection<CustomerType> findAll() {
		return readService.findAll();
	}
	
}
