package com.hyperbank.interests.interestrate.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.interests.interestrate.entity.InterestRate;
import com.hyperbank.interests.interestrate.repository.InterestRateRepository;
import com.hyperbank.interests.interestrate.service.InterestRateService;
import com.hyperbank.interests.interestratetype.service.InterestRateTypeService;

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
public class InterestRateServiceImpl implements InterestRateService {

	public InterestRateServiceImpl(InterestRateRepository interestRateRepository, InterestRateTypeService interestRateTypeService) {
		createServiceHelper = new CreateServiceHelperImpl<>(interestRateRepository, InterestRate::getId);
		readServiceHelper = new ReadServiceHelperImpl<>(interestRateRepository, ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(InterestRate.class));
		deleteServiceHelper = new DeleteServiceHelperImpl<>(interestRateRepository, readServiceHelper);
		this.interestRateTypeService = interestRateTypeService;
	}

	private final CreateServiceHelper<Long, InterestRate> createServiceHelper;
	private final ReadServiceHelper<Long, InterestRate> readServiceHelper;
	private final DeleteServiceHelper<Long> deleteServiceHelper;

	private final InterestRateTypeService interestRateTypeService;
	
	@Override
	@Transactional(readOnly = true)
	public InterestRate getReferenceById(Long id) {
		return readServiceHelper.getReferenceById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public InterestRate findById(Long id) throws FunctionalException {
		return readServiceHelper.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<InterestRate> findManyById(Collection<Long> ids) throws FunctionalException {
		return readServiceHelper.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<InterestRate> findManyByIdIfPresent(Collection<Long> ids) {
		return readServiceHelper.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<InterestRate> findAll() {
		return readServiceHelper.findAll();
	}

	@Override
	public InterestRate saveWithInterestRateFixedType() throws FunctionalException {
		InterestRate interestRate = new InterestRate();
		interestRate.setInterestRateType(interestRateTypeService.getReferenceById(1));
		return createServiceHelper.saveAndReturn(interestRate);
	}
	
	@Override
	public InterestRate saveWithInterestRateVariableType() throws FunctionalException {
		InterestRate interestRate = new InterestRate();
		interestRate.setInterestRateType(interestRateTypeService.getReferenceById(2));
		return createServiceHelper.saveAndReturn(interestRate);
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
