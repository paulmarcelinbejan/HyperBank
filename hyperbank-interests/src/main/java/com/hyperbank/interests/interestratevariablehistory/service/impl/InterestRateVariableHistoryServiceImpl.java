package com.hyperbank.interests.interestratevariablehistory.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.interests.interestratevariable.entity.InterestRateVariable;
import com.hyperbank.interests.interestratevariablehistory.entity.InterestRateVariableHistory;
import com.hyperbank.interests.interestratevariablehistory.mapper.InterestRateVariableHistoryMapper;
import com.hyperbank.interests.interestratevariablehistory.repository.InterestRateVariableHistoryRepository;
import com.hyperbank.interests.interestratevariablehistory.service.InterestRateVariableHistoryService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.utils.time.localdate.LocalDateUtils;
import com.paulmarcelinbejan.toolbox.web.service.CreateService;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;
import com.paulmarcelinbejan.toolbox.web.service.UpdateService;
import com.paulmarcelinbejan.toolbox.web.service.impl.CreateServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.impl.ReadServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.impl.UpdateServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.utils.ServiceUtils;

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class InterestRateVariableHistoryServiceImpl implements InterestRateVariableHistoryService {
	
	public InterestRateVariableHistoryServiceImpl(InterestRateVariableHistoryRepository interestRateVariableHistoryRepository, InterestRateVariableHistoryMapper interestRateVariableHistoryMapper) {
		createService = new CreateServiceImpl<>(interestRateVariableHistoryRepository, InterestRateVariableHistory::getId);
		readService = new ReadServiceImpl<>(interestRateVariableHistoryRepository, ServiceUtils.buildErrorMessageIfEntityNotFoundById(InterestRateVariable.class));
		updateService = new UpdateServiceImpl<>(
				interestRateVariableHistoryRepository,
				interestRateVariableHistoryMapper,
				readService,
				InterestRateVariableHistory::getId);
		
		this.interestRateVariableHistoryRepository = interestRateVariableHistoryRepository;
	}
	
	private final CreateService<Long, InterestRateVariableHistory> createService;
	private final ReadService<Long, InterestRateVariableHistory> readService;
	private final UpdateService<Long, InterestRateVariableHistory> updateService;
	
	private final InterestRateVariableHistoryRepository interestRateVariableHistoryRepository;
	
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
	public Optional<InterestRateVariableHistory> findFirstByInterestRateVariableOrderByStartDateDesc(Long interestRateVariableId) {
		return interestRateVariableHistoryRepository.findFirstByInterestRateVariableOrderByStartDateDesc(interestRateVariableId);
	}
	
	@Override
	public Long save(InterestRateVariableHistory entity) throws FunctionalException {
		return saveAndReturn(entity).getId();
	}
	
	@Override
	public InterestRateVariableHistory saveAndReturn(InterestRateVariableHistory entity) throws FunctionalException {
		InterestRateVariable interestRateVariable = entity.getInterestRateVariable();
		List<InterestRateVariableHistory> history = interestRateVariable.getHistory();
		
		if(!history.isEmpty()) {
			InterestRateVariableHistory lastValidInterestRate = history.get(history.size() - 1);
			lastValidInterestRate.setEndDate(LocalDateUtils.lastDayOfPreviousMonth(entity.getStartDate()));
			update(lastValidInterestRate);
		}
		
		return createService.saveAndReturn(entity);
	}

	@Override
	public Collection<Long> save(Collection<InterestRateVariableHistory> entities) throws FunctionalException {
		Collection<Long> savedEntities = new ArrayList<>();
		for(InterestRateVariableHistory entity : entities) {
			savedEntities.add(save(entity));
		}
		return savedEntities;
	}
	
	@Override
	public Collection<InterestRateVariableHistory> saveAndReturn(Collection<InterestRateVariableHistory> entities) throws FunctionalException {
		Collection<InterestRateVariableHistory> savedEntities = new ArrayList<>();
		for(InterestRateVariableHistory entity : entities) {
			savedEntities.add(saveAndReturn(entity));
		}
		return savedEntities;
	}
	
	private Long update(InterestRateVariableHistory entity) throws FunctionalException {
		return updateService.update(entity);
	}
	
}
