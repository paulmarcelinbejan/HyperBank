package com.hyperbank.interests.interestratevariablehistory.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.interests.interestratevariable.entity.InterestRateVariable;
import com.hyperbank.interests.interestratevariablehistory.entity.InterestRateVariableHistory;
import com.hyperbank.interests.interestratevariablehistory.repository.InterestRateVariableHistoryRepository;
import com.hyperbank.interests.interestratevariablehistory.service.InterestRateVariableHistoryService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.web.service.CreateService;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;
import com.paulmarcelinbejan.toolbox.web.service.impl.CreateServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.impl.ReadServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.utils.ServiceUtils;

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class InterestRateVariableHistoryServiceImpl implements InterestRateVariableHistoryService {
	
	public InterestRateVariableHistoryServiceImpl(InterestRateVariableHistoryRepository interestRateVariableHistoryRepository) {
		createService = new CreateServiceImpl<>(interestRateVariableHistoryRepository, InterestRateVariableHistory::getId);
		readService = new ReadServiceImpl<>(interestRateVariableHistoryRepository, ServiceUtils.buildErrorMessageIfEntityNotFoundById(InterestRateVariable.class));
	}
	
	private final CreateService<Long, InterestRateVariableHistory> createService;
	private final ReadService<Long, InterestRateVariableHistory> readService;
	
	@Override
	@Transactional(readOnly = true)
	public InterestRateVariableHistory getReferenceById(Long id) {
		return readService.getReferenceById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public InterestRateVariableHistory findById(Long id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<InterestRateVariableHistory> findManyById(Collection<Long> ids) throws FunctionalException {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<InterestRateVariableHistory> findManyByIdIfPresent(Collection<Long> ids) {
		return readService.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<InterestRateVariableHistory> findAll() {
		return readService.findAll();
	}

	@Override
	public Long save(InterestRateVariableHistory entity) {
		return createService.save(entity);
	}
	
	@Override
	public InterestRateVariableHistory saveAndReturn(InterestRateVariableHistory entity) {
		return createService.saveAndReturn(entity);
	}

	@Override
	public Collection<Long> save(Collection<InterestRateVariableHistory> entities) {
		return createService.save(entities);
	}
	
	@Override
	public Collection<InterestRateVariableHistory> saveAndReturn(Collection<InterestRateVariableHistory> entities) {
		return createService.saveAndReturn(entities);
	}


}
