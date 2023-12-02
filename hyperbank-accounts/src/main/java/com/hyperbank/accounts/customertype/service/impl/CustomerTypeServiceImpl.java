package com.hyperbank.accounts.customertype.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.accounts.customertype.entity.CustomerType;
import com.hyperbank.accounts.customertype.repository.CustomerTypeRepository;
import com.hyperbank.accounts.customertype.service.CustomerTypeService;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import io.github.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.impl.ReadServiceHelperImpl;
import io.github.paulmarcelinbejan.toolbox.service.helper.utils.ServiceHelperUtils;

@Service
@Transactional(readOnly = true, rollbackFor = { FunctionalException.class, TechnicalException.class })
public class CustomerTypeServiceImpl implements CustomerTypeService {

	public CustomerTypeServiceImpl(CustomerTypeRepository customerTypeRepository) {
		readServiceHelper = new ReadServiceHelperImpl<>(customerTypeRepository, ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(CustomerType.class));
	}

	private final ReadServiceHelper<Integer, CustomerType> readServiceHelper;
	
	@Override
	public CustomerType getReferenceById(Integer id) {
		return readServiceHelper.getReferenceById(id);
	}
	
	@Override
	public CustomerType findById(Integer id) throws FunctionalException {
		return readServiceHelper.findById(id);
	}

	@Override
	public List<CustomerType> findManyById(Collection<Integer> ids) throws FunctionalException {
		return readServiceHelper.findManyById(ids);
	}

	@Override
	public List<CustomerType> findManyByIdIfPresent(Collection<Integer> ids) {
		return readServiceHelper.findManyByIdIfPresent(ids);
	}

	@Override
	public List<CustomerType> findAll() {
		return readServiceHelper.findAll();
	}
	
}
