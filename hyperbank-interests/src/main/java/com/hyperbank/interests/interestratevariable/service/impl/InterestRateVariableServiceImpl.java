package com.hyperbank.interests.interestratevariable.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.interests.interestrate.entity.InterestRate;
import com.hyperbank.interests.interestrate.service.InterestRateService;
import com.hyperbank.interests.interestratevariable.entity.InterestRateVariable;
import com.hyperbank.interests.interestratevariable.repository.InterestRateVariableRepository;
import com.hyperbank.interests.interestratevariable.service.InterestRateVariableService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.web.service.CreateService;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;
import com.paulmarcelinbejan.toolbox.web.service.impl.CreateServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.impl.ReadServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.utils.ServiceUtils;

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class InterestRateVariableServiceImpl implements InterestRateVariableService {

	public InterestRateVariableServiceImpl(InterestRateVariableRepository interestRateVariableRepository, InterestRateService interestRateService) {
		createService = new CreateServiceImpl<>(interestRateVariableRepository, InterestRateVariable::getId);
		readService = new ReadServiceImpl<>(interestRateVariableRepository, ServiceUtils.buildErrorMessageIfEntityNotFoundById(InterestRateVariable.class));
		
		this.interestRateService = interestRateService;
	}

	private final CreateService<Long, InterestRateVariable> createService;
	private final ReadService<Long, InterestRateVariable> readService;
	
	private final InterestRateService interestRateService;
	
	@Override
	@Transactional(readOnly = true)
	public InterestRateVariable getReferenceById(Long id) {
		return readService.getReferenceById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public InterestRateVariable findById(Long id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<InterestRateVariable> findManyById(Collection<Long> ids) throws FunctionalException {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<InterestRateVariable> findManyByIdIfPresent(Collection<Long> ids) {
		return readService.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<InterestRateVariable> findAll() {
		return readService.findAll();
	}

	@Override
	public Long save(InterestRateVariable entity) {
		return saveAndReturn(entity).getId();
	}

	@Override
	public InterestRateVariable saveAndReturn(InterestRateVariable entity) {
		InterestRate interestRate = interestRateService.saveWithInterestRateVariableType();
		entity.setInterestRate(interestRate);
		return createService.saveAndReturn(entity);
	}

	@Override
	public Collection<Long> save(Collection<InterestRateVariable> entities) {
		entities = saveAndReturn(entities);
		return entities.stream()
				       .map(InterestRateVariable::getId)
				       .toList();
	}

	@Override
	public Collection<InterestRateVariable> saveAndReturn(Collection<InterestRateVariable> entities) {
		return entities.stream()
			   	   .map(this::saveAndReturn)
			   	   .toList();
	}
	
	@Override
	public Long update(InterestRateVariable entity) throws FunctionalException {
		return updateAndReturn(entity).getId();
	}

	@Override
	public InterestRateVariable updateAndReturn(InterestRateVariable entity) throws FunctionalException {
		return readService.findById(entity.getId());
	}
	
	@Override
	public Collection<Long> update(Collection<InterestRateVariable> entities) throws FunctionalException {
		entities = updateAndReturn(entities);
		return entities.stream()
				       .map(InterestRateVariable::getId)
				       .toList();
	}
	
	@Override
	public Collection<InterestRateVariable> updateAndReturn(Collection<InterestRateVariable> entities) throws FunctionalException {
		Collection<InterestRateVariable> updatedCollection = new ArrayList<>();
		for(InterestRateVariable entity : entities) {
			updatedCollection.add(updateAndReturn(entity));
		}
		return updatedCollection;
	}

	
}
