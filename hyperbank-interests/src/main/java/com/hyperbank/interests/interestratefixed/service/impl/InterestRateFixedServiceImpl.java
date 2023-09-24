package com.hyperbank.interests.interestratefixed.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.interests.interestrate.entity.InterestRate;
import com.hyperbank.interests.interestrate.service.InterestRateService;
import com.hyperbank.interests.interestratefixed.entity.InterestRateFixed;
import com.hyperbank.interests.interestratefixed.repository.InterestRateFixedRepository;
import com.hyperbank.interests.interestratefixed.service.InterestRateFixedService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.web.service.CreateService;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;
import com.paulmarcelinbejan.toolbox.web.service.impl.CreateServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.impl.ReadServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.utils.ServiceUtils;

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class InterestRateFixedServiceImpl implements InterestRateFixedService {

	public InterestRateFixedServiceImpl(InterestRateFixedRepository interestRateFixedRepository, InterestRateService interestRateService) {
		createService = new CreateServiceImpl<>(interestRateFixedRepository, InterestRateFixed::getId);
		readService = new ReadServiceImpl<>(interestRateFixedRepository, ServiceUtils.buildErrorMessageIfEntityNotFoundById(InterestRateFixed.class));
		this.interestRateService = interestRateService;
	}

	private final CreateService<Long, InterestRateFixed> createService;
	private final ReadService<Long, InterestRateFixed> readService;

	private final InterestRateService interestRateService;
	
	@Override
	@Transactional(readOnly = true)
	public InterestRateFixed getReferenceById(Long id) {
		return readService.getReferenceById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public InterestRateFixed findById(Long id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<InterestRateFixed> findManyById(Collection<Long> ids) throws FunctionalException {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<InterestRateFixed> findManyByIdIfPresent(Collection<Long> ids) {
		return readService.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<InterestRateFixed> findAll() {
		return readService.findAll();
	}

	@Override
	public Long save(InterestRateFixed entity) throws FunctionalException {
		return saveAndReturn(entity).getId();
	}

	@Override
	public InterestRateFixed saveAndReturn(InterestRateFixed entity) throws FunctionalException {
		InterestRate interestRate = interestRateService.saveWithInterestRateFixedType();
		entity.setInterestRate(interestRate);
		return createService.saveAndReturn(entity);
	}

	@Override
	public Collection<Long> save(Collection<InterestRateFixed> entities) throws FunctionalException {
		Collection<Long> savedEntities = new ArrayList<>();
		for(InterestRateFixed entity : entities) {
			savedEntities.add(save(entity));
		}
		return savedEntities;
	}

	@Override
	public Collection<InterestRateFixed> saveAndReturn(Collection<InterestRateFixed> entities) throws FunctionalException {
		Collection<InterestRateFixed> savedEntities = new ArrayList<>();
		for(InterestRateFixed entity : entities) {
			savedEntities.add(saveAndReturn(entity));
		}
		return savedEntities;
	}
	
}
