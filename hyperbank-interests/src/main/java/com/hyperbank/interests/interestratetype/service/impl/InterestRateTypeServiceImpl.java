package com.hyperbank.interests.interestratetype.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.interests.interestratetype.entity.InterestRateType;
import com.hyperbank.interests.interestratetype.mapper.InterestRateTypeMapper;
import com.hyperbank.interests.interestratetype.repository.InterestRateTypeRepository;
import com.hyperbank.interests.interestratetype.service.InterestRateTypeService;
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
public class InterestRateTypeServiceImpl implements InterestRateTypeService {

	public InterestRateTypeServiceImpl(InterestRateTypeMapper interestRateTypeMapper, InterestRateTypeRepository interestRateTypeRepository) {
		createService = new CreateServiceImpl<>(interestRateTypeRepository, InterestRateType::getId);
		readService = new ReadServiceImpl<>(interestRateTypeRepository, ServiceUtils.buildErrorMessageIfEntityNotFoundById(InterestRateType.class));
		updateService = new UpdateServiceImpl<>(
				interestRateTypeRepository,
				interestRateTypeMapper,
				readService,
				InterestRateType::getId);
		deleteService = new DeleteServiceImpl<>(interestRateTypeRepository, readService);
	}

	private final CreateService<Integer, InterestRateType> createService;
	private final ReadService<Integer, InterestRateType> readService;
	private final UpdateService<Integer, InterestRateType> updateService;
	private final DeleteService<Integer> deleteService;

	@Override
	@Transactional(readOnly = true)
	public InterestRateType getReferenceById(Integer id) {
		return readService.getReferenceById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public InterestRateType findById(Integer id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<InterestRateType> findManyById(Collection<Integer> ids) throws FunctionalException {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<InterestRateType> findManyByIdIfPresent(Collection<Integer> ids) {
		return readService.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<InterestRateType> findAll() {
		return readService.findAll();
	}

	@Override
	public Integer save(InterestRateType entity) {
		return createService.save(entity);
	}

	@Override
	public InterestRateType saveAndReturn(InterestRateType entity) {
		return createService.saveAndReturn(entity);
	}

	@Override
	public Collection<Integer> save(Collection<InterestRateType> entities) {
		return createService.save(entities);
	}

	@Override
	public Collection<InterestRateType> saveAndReturn(Collection<InterestRateType> entities) {
		return createService.saveAndReturn(entities);
	}

	@Override
	public Integer update(InterestRateType entity) throws FunctionalException {
		return updateService.update(entity);
	}

	@Override
	public InterestRateType updateAndReturn(InterestRateType entity) throws FunctionalException {
		return updateService.updateAndReturn(entity);
	}
	
	@Override
	public Collection<Integer> update(Collection<InterestRateType> entities) throws FunctionalException {
		return updateService.update(entities);
	}
	
	@Override
	public Collection<InterestRateType> updateAndReturn(Collection<InterestRateType> entities) throws FunctionalException {
		return updateService.updateAndReturn(entities);
	}

	@Override
	public void delete(Integer id) throws FunctionalException {
		deleteService.delete(id);
	}
	
	@Override
	public void deleteIfPresent(Integer id) {
		deleteService.deleteIfPresent(id);
	}

	@Override
	public void deleteMany(Collection<Integer> ids) throws FunctionalException {
		deleteService.deleteMany(ids);
	}

	@Override
	public void deleteManyIfPresent(Collection<Integer> ids) {
		deleteService.deleteManyIfPresent(ids);
	}
	
}
