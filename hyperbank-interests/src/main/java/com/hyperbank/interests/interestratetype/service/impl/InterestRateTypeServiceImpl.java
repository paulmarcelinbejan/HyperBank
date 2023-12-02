package com.hyperbank.interests.interestratetype.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.interests.interestratetype.entity.InterestRateType;
import com.hyperbank.interests.interestratetype.mapper.InterestRateTypeMapper;
import com.hyperbank.interests.interestratetype.repository.InterestRateTypeRepository;
import com.hyperbank.interests.interestratetype.service.InterestRateTypeService;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import io.github.paulmarcelinbejan.toolbox.service.helper.CreateServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.DeleteServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.UpdateServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.impl.CreateServiceHelperImpl;
import io.github.paulmarcelinbejan.toolbox.service.helper.impl.DeleteServiceHelperImpl;
import io.github.paulmarcelinbejan.toolbox.service.helper.impl.ReadServiceHelperImpl;
import io.github.paulmarcelinbejan.toolbox.service.helper.impl.UpdateServiceHelperImpl;
import io.github.paulmarcelinbejan.toolbox.service.helper.utils.ServiceHelperUtils;

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class InterestRateTypeServiceImpl implements InterestRateTypeService {

	public InterestRateTypeServiceImpl(InterestRateTypeMapper interestRateTypeMapper, InterestRateTypeRepository interestRateTypeRepository) {
		createServiceHelper = new CreateServiceHelperImpl<>(interestRateTypeRepository, InterestRateType::getId);
		readServiceHelper = new ReadServiceHelperImpl<>(interestRateTypeRepository, ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(InterestRateType.class));
		updateServiceHelper = new UpdateServiceHelperImpl<>(
				interestRateTypeRepository,
				interestRateTypeMapper,
				readServiceHelper,
				InterestRateType::getId);
		deleteServiceHelper = new DeleteServiceHelperImpl<>(interestRateTypeRepository, readServiceHelper);
	}

	private final CreateServiceHelper<Integer, InterestRateType> createServiceHelper;
	private final ReadServiceHelper<Integer, InterestRateType> readServiceHelper;
	private final UpdateServiceHelper<Integer, InterestRateType> updateServiceHelper;
	private final DeleteServiceHelper<Integer> deleteServiceHelper;

	@Override
	@Transactional(readOnly = true)
	public InterestRateType getReferenceById(Integer id) {
		return readServiceHelper.getReferenceById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public InterestRateType findById(Integer id) throws FunctionalException {
		return readServiceHelper.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<InterestRateType> findManyById(Collection<Integer> ids) throws FunctionalException {
		return readServiceHelper.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<InterestRateType> findManyByIdIfPresent(Collection<Integer> ids) {
		return readServiceHelper.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<InterestRateType> findAll() {
		return readServiceHelper.findAll();
	}

	@Override
	public Integer save(InterestRateType entity) throws FunctionalException {
		return createServiceHelper.save(entity);
	}

	@Override
	public InterestRateType saveAndReturn(InterestRateType entity) throws FunctionalException {
		return createServiceHelper.saveAndReturn(entity);
	}

	@Override
	public List<Integer> save(Collection<InterestRateType> entities) throws FunctionalException {
		return createServiceHelper.save(entities);
	}

	@Override
	public List<InterestRateType> saveAndReturn(Collection<InterestRateType> entities) throws FunctionalException {
		return createServiceHelper.saveAndReturn(entities);
	}

	@Override
	public Integer update(InterestRateType entity) throws FunctionalException {
		return updateServiceHelper.update(entity);
	}

	@Override
	public InterestRateType updateAndReturn(InterestRateType entity) throws FunctionalException {
		return updateServiceHelper.updateAndReturn(entity);
	}
	
	@Override
	public List<Integer> update(Collection<InterestRateType> entities) throws FunctionalException {
		return updateServiceHelper.update(entities);
	}
	
	@Override
	public List<InterestRateType> updateAndReturn(Collection<InterestRateType> entities) throws FunctionalException {
		return updateServiceHelper.updateAndReturn(entities);
	}

	@Override
	public void delete(Integer id) throws FunctionalException {
		deleteServiceHelper.delete(id);
	}
	
	@Override
	public void deleteIfPresent(Integer id) {
		deleteServiceHelper.deleteIfPresent(id);
	}

	@Override
	public void deleteMany(Collection<Integer> ids) throws FunctionalException {
		deleteServiceHelper.deleteMany(ids);
	}

	@Override
	public void deleteManyIfPresent(Collection<Integer> ids) {
		deleteServiceHelper.deleteManyIfPresent(ids);
	}
	
}
