package com.hyperbank.interests.interestratevariable.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.interests.interestratevariable.entity.InterestRateVariable;
import com.hyperbank.interests.interestratevariable.mapper.InterestRateVariableMapper;
import com.hyperbank.interests.interestratevariable.repository.InterestRateVariableRepository;
import com.hyperbank.interests.interestratevariable.service.InterestRateVariableService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.web.service.CreateService;
import com.paulmarcelinbejan.toolbox.web.service.DeleteService;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;
import com.paulmarcelinbejan.toolbox.web.service.UpdateService;
import com.paulmarcelinbejan.toolbox.web.service.impl.CreateServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.impl.DeleteServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.impl.ReadServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.impl.UpdateServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.utils.ServiceUtils;

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class InterestRateVariableServiceImpl implements InterestRateVariableService {

	public InterestRateVariableServiceImpl(InterestRateVariableMapper interestRateVariableMapper, InterestRateVariableRepository interestRateVariableRepository) {
		createService = new CreateServiceImpl<>(interestRateVariableRepository, InterestRateVariable::getId);
		readService = new ReadServiceImpl<>(interestRateVariableRepository, ServiceUtils.buildErrorMessageIfEntityNotFoundById(InterestRateVariable.class));
		updateService = new UpdateServiceImpl<>(
				interestRateVariableRepository,
				interestRateVariableMapper,
				readService,
				InterestRateVariable::getId);
		deleteService = new DeleteServiceImpl<>(interestRateVariableRepository, readService);
	}

	private final CreateService<Long, InterestRateVariable> createService;
	private final ReadService<Long, InterestRateVariable> readService;
	private final UpdateService<Long, InterestRateVariable> updateService;
	private final DeleteService<Long> deleteService;

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
		return createService.save(entity);
	}

	@Override
	public InterestRateVariable saveAndReturn(InterestRateVariable entity) {
		return createService.saveAndReturn(entity);
	}

	@Override
	public Collection<Long> save(Collection<InterestRateVariable> entities) {
		return createService.save(entities);
	}

	@Override
	public Collection<InterestRateVariable> saveAndReturn(Collection<InterestRateVariable> entities) {
		return createService.saveAndReturn(entities);
	}

	@Override
	public Long update(InterestRateVariable entity) throws FunctionalException {
		return updateService.update(entity);
	}

	@Override
	public InterestRateVariable updateAndReturn(InterestRateVariable entity) throws FunctionalException {
		return updateService.updateAndReturn(entity);
	}
	
	@Override
	public Collection<Long> update(Collection<InterestRateVariable> entities) throws FunctionalException {
		return updateService.update(entities);
	}
	
	@Override
	public Collection<InterestRateVariable> updateAndReturn(Collection<InterestRateVariable> entities) throws FunctionalException {
		return updateService.updateAndReturn(entities);
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
