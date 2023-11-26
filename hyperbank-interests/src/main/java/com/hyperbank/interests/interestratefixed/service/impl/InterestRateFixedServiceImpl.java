package com.hyperbank.interests.interestratefixed.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.interests.interestrate.entity.InterestRate;
import com.hyperbank.interests.interestrate.service.InterestRateService;
import com.hyperbank.interests.interestratefixed.entity.InterestRateFixed;
import com.hyperbank.interests.interestratefixed.repository.InterestRateFixedRepository;
import com.hyperbank.interests.interestratefixed.service.InterestRateFixedService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.service.helper.CreateServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.impl.CreateServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.impl.ReadServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.utils.ServiceHelperUtils;

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class InterestRateFixedServiceImpl implements InterestRateFixedService {

	public InterestRateFixedServiceImpl(InterestRateFixedRepository interestRateFixedRepository, InterestRateService interestRateService) {
		createServiceHelper = new CreateServiceHelperImpl<>(interestRateFixedRepository, InterestRateFixed::getId);
		readServiceHelper = new ReadServiceHelperImpl<>(interestRateFixedRepository, ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(InterestRateFixed.class));
		this.interestRateService = interestRateService;
	}

	private final CreateServiceHelper<Long, InterestRateFixed> createServiceHelper;
	private final ReadServiceHelper<Long, InterestRateFixed> readServiceHelper;

	private final InterestRateService interestRateService;
	
	@Override
	@Transactional(readOnly = true)
	public InterestRateFixed getReferenceById(Long id) {
		return readServiceHelper.getReferenceById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public InterestRateFixed findById(Long id) throws FunctionalException {
		return readServiceHelper.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<InterestRateFixed> findManyById(Collection<Long> ids) throws FunctionalException {
		return readServiceHelper.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<InterestRateFixed> findManyByIdIfPresent(Collection<Long> ids) {
		return readServiceHelper.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<InterestRateFixed> findAll() {
		return readServiceHelper.findAll();
	}

	@Override
	public Long save(InterestRateFixed entity) throws FunctionalException {
		return saveAndReturn(entity).getId();
	}

	@Override
	public InterestRateFixed saveAndReturn(InterestRateFixed entity) throws FunctionalException {
		InterestRate interestRate = interestRateService.saveWithInterestRateFixedType();
		entity.setInterestRate(interestRate);
		return createServiceHelper.saveAndReturn(entity);
	}

	@Override
	public List<Long> save(Collection<InterestRateFixed> entities) throws FunctionalException {
		List<Long> savedEntities = new ArrayList<>();
		for(InterestRateFixed entity : entities) {
			savedEntities.add(save(entity));
		}
		return savedEntities;
	}

	@Override
	public List<InterestRateFixed> saveAndReturn(Collection<InterestRateFixed> entities) throws FunctionalException {
		List<InterestRateFixed> savedEntities = new ArrayList<>();
		for(InterestRateFixed entity : entities) {
			savedEntities.add(saveAndReturn(entity));
		}
		return savedEntities;
	}
	
}
