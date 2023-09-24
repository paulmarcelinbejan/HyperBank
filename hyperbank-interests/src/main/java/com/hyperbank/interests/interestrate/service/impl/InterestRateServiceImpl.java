package com.hyperbank.interests.interestrate.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.interests.interestrate.entity.InterestRate;
import com.hyperbank.interests.interestrate.repository.InterestRateRepository;
import com.hyperbank.interests.interestrate.service.InterestRateService;
import com.hyperbank.interests.interestratetype.service.InterestRateTypeService;
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
public class InterestRateServiceImpl implements InterestRateService {

	public InterestRateServiceImpl(InterestRateRepository interestRateRepository, InterestRateTypeService interestRateTypeService) {
		createService = new CreateServiceImpl<>(interestRateRepository, InterestRate::getId);
		readService = new ReadServiceImpl<>(interestRateRepository, ServiceUtils.buildErrorMessageIfEntityNotFoundById(InterestRate.class));
		deleteService = new DeleteServiceImpl<>(interestRateRepository, readService);
		this.interestRateTypeService = interestRateTypeService;
	}

	private final CreateService<Long, InterestRate> createService;
	private final ReadService<Long, InterestRate> readService;
	private final DeleteService<Long> deleteService;

	private final InterestRateTypeService interestRateTypeService;
	
	@Override
	@Transactional(readOnly = true)
	public InterestRate getReferenceById(Long id) {
		return readService.getReferenceById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public InterestRate findById(Long id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<InterestRate> findManyById(Collection<Long> ids) throws FunctionalException {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<InterestRate> findManyByIdIfPresent(Collection<Long> ids) {
		return readService.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<InterestRate> findAll() {
		return readService.findAll();
	}

	@Override
	public InterestRate saveWithInterestRateFixedType() throws FunctionalException {
		InterestRate interestRate = new InterestRate();
		interestRate.setInterestRateType(interestRateTypeService.getReferenceById(1));
		return createService.saveAndReturn(interestRate);
	}
	
	@Override
	public InterestRate saveWithInterestRateVariableType() throws FunctionalException {
		InterestRate interestRate = new InterestRate();
		interestRate.setInterestRateType(interestRateTypeService.getReferenceById(2));
		return createService.saveAndReturn(interestRate);
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