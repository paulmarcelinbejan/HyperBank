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
import com.paulmarcelinbejan.toolbox.service.helper.CreateServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.UpdateServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.impl.CreateServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.impl.ReadServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.impl.UpdateServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.utils.ServiceHelperUtils;
import com.paulmarcelinbejan.toolbox.utils.time.localdate.LocalDateUtils;

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class InterestRateVariableHistoryServiceImpl implements InterestRateVariableHistoryService {
	
	public InterestRateVariableHistoryServiceImpl(InterestRateVariableHistoryRepository interestRateVariableHistoryRepository, InterestRateVariableHistoryMapper interestRateVariableHistoryMapper) {
		createServiceHelper = new CreateServiceHelperImpl<>(interestRateVariableHistoryRepository, InterestRateVariableHistory::getId);
		readServiceHelper = new ReadServiceHelperImpl<>(interestRateVariableHistoryRepository, ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(InterestRateVariable.class));
		updateServiceHelper = new UpdateServiceHelperImpl<>(
				interestRateVariableHistoryRepository,
				interestRateVariableHistoryMapper,
				readServiceHelper,
				InterestRateVariableHistory::getId);
		
		this.interestRateVariableHistoryRepository = interestRateVariableHistoryRepository;
	}
	
	private final CreateServiceHelper<Long, InterestRateVariableHistory> createServiceHelper;
	private final ReadServiceHelper<Long, InterestRateVariableHistory> readServiceHelper;
	private final UpdateServiceHelper<Long, InterestRateVariableHistory> updateServiceHelper;
	
	private final InterestRateVariableHistoryRepository interestRateVariableHistoryRepository;
	
	@Override
	@Transactional(readOnly = true)
	public InterestRateVariableHistory getReferenceById(Long id) {
		return readServiceHelper.getReferenceById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public InterestRateVariableHistory findById(Long id) throws FunctionalException {
		return readServiceHelper.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<InterestRateVariableHistory> findManyById(Collection<Long> ids) throws FunctionalException {
		return readServiceHelper.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<InterestRateVariableHistory> findManyByIdIfPresent(Collection<Long> ids) {
		return readServiceHelper.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<InterestRateVariableHistory> findAll() {
		return readServiceHelper.findAll();
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
		
		return createServiceHelper.saveAndReturn(entity);
	}

	@Override
	public List<Long> save(Collection<InterestRateVariableHistory> entities) throws FunctionalException {
		List<Long> savedEntities = new ArrayList<>();
		for(InterestRateVariableHistory entity : entities) {
			savedEntities.add(save(entity));
		}
		return savedEntities;
	}
	
	@Override
	public List<InterestRateVariableHistory> saveAndReturn(Collection<InterestRateVariableHistory> entities) throws FunctionalException {
		List<InterestRateVariableHistory> savedEntities = new ArrayList<>();
		for(InterestRateVariableHistory entity : entities) {
			savedEntities.add(saveAndReturn(entity));
		}
		return savedEntities;
	}
	
	private Long update(InterestRateVariableHistory entity) throws FunctionalException {
		return updateServiceHelper.update(entity);
	}
	
}
