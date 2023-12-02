package com.hyperbank.interests.interestratevariable.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.interests.interestrate.entity.InterestRate;
import com.hyperbank.interests.interestrate.service.InterestRateService;
import com.hyperbank.interests.interestratevariable.entity.InterestRateVariable;
import com.hyperbank.interests.interestratevariable.repository.InterestRateVariableRepository;
import com.hyperbank.interests.interestratevariable.service.InterestRateVariableService;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import io.github.paulmarcelinbejan.toolbox.service.helper.CreateServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.impl.CreateServiceHelperImpl;
import io.github.paulmarcelinbejan.toolbox.service.helper.impl.ReadServiceHelperImpl;
import io.github.paulmarcelinbejan.toolbox.service.helper.utils.ServiceHelperUtils;

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class InterestRateVariableServiceImpl implements InterestRateVariableService {

	public InterestRateVariableServiceImpl(InterestRateVariableRepository interestRateVariableRepository, InterestRateService interestRateService) {
		createServiceHelper = new CreateServiceHelperImpl<>(interestRateVariableRepository, InterestRateVariable::getId);
		readServiceHelper = new ReadServiceHelperImpl<>(interestRateVariableRepository, ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(InterestRateVariable.class));
		
		this.interestRateService = interestRateService;
	}

	private final CreateServiceHelper<Long, InterestRateVariable> createServiceHelper;
	private final ReadServiceHelper<Long, InterestRateVariable> readServiceHelper;
	
	private final InterestRateService interestRateService;
	
	@Override
	@Transactional(readOnly = true)
	public InterestRateVariable getReferenceById(Long id) {
		return readServiceHelper.getReferenceById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public InterestRateVariable findById(Long id) throws FunctionalException {
		return readServiceHelper.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<InterestRateVariable> findManyById(Collection<Long> ids) throws FunctionalException {
		return readServiceHelper.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<InterestRateVariable> findManyByIdIfPresent(Collection<Long> ids) {
		return readServiceHelper.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<InterestRateVariable> findAll() {
		return readServiceHelper.findAll();
	}

	@Override
	public Long save(InterestRateVariable entity) throws FunctionalException {
		return saveAndReturn(entity).getId();
	}

	@Override
	public InterestRateVariable saveAndReturn(InterestRateVariable entity) throws FunctionalException {
		InterestRate interestRate = interestRateService.saveWithInterestRateVariableType();
		entity.setInterestRate(interestRate);
		return createServiceHelper.saveAndReturn(entity);
	}

	@Override
	public List<Long> save(Collection<InterestRateVariable> entities) throws FunctionalException {
		List<Long> savedEntities = new ArrayList<>();
		for(InterestRateVariable entity : entities) {
			savedEntities.add(save(entity));
		}
		return savedEntities;
	}

	@Override
	public List<InterestRateVariable> saveAndReturn(Collection<InterestRateVariable> entities) throws FunctionalException {
		List<InterestRateVariable> savedEntities = new ArrayList<>();
		for(InterestRateVariable entity : entities) {
			savedEntities.add(saveAndReturn(entity));
		}
		return savedEntities;
	}
	
}
