package com.hyperbank.types.sextype.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.types.sextype.entity.SexType;
import com.hyperbank.types.sextype.mapper.SexTypeMapper;
import com.hyperbank.types.sextype.repository.SexTypeRepository;
import com.hyperbank.types.sextype.service.SexTypeService;

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
public class SexTypeServiceImpl implements SexTypeService {

	public SexTypeServiceImpl(SexTypeMapper sexTypeMapper, SexTypeRepository sexTypeRepository) {
		createServiceHelper = new CreateServiceHelperImpl<>(sexTypeRepository, SexType::getId);
		readServiceHelper = new ReadServiceHelperImpl<>(sexTypeRepository, ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(SexType.class));
		updateServiceHelper = new UpdateServiceHelperImpl<>(
				sexTypeRepository,
				sexTypeMapper,
				readServiceHelper,
				SexType::getId);
		deleteServiceHelper = new DeleteServiceHelperImpl<>(sexTypeRepository, readServiceHelper);
	}

	private final CreateServiceHelper<Integer, SexType> createServiceHelper;
	private final ReadServiceHelper<Integer, SexType> readServiceHelper;
	private final UpdateServiceHelper<Integer, SexType> updateServiceHelper;
	private final DeleteServiceHelper<Integer> deleteServiceHelper;

	@Override
	@Transactional(readOnly = true)
	public SexType getReferenceById(Integer id) {
		return readServiceHelper.getReferenceById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public SexType findById(Integer id) throws FunctionalException {
		return readServiceHelper.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SexType> findManyById(Collection<Integer> ids) throws FunctionalException {
		return readServiceHelper.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SexType> findManyByIdIfPresent(Collection<Integer> ids) {
		return readServiceHelper.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SexType> findAll() {
		return readServiceHelper.findAll();
	}

	@Override
	public Integer save(SexType entity) throws FunctionalException {
		return createServiceHelper.save(entity);
	}

	@Override
	public SexType saveAndReturn(SexType entity) throws FunctionalException {
		return createServiceHelper.saveAndReturn(entity);
	}

	@Override
	public List<Integer> save(Collection<SexType> entities) throws FunctionalException {
		return createServiceHelper.save(entities);
	}

	@Override
	public List<SexType> saveAndReturn(Collection<SexType> entities) throws FunctionalException {
		return createServiceHelper.saveAndReturn(entities);
	}

	@Override
	public Integer update(SexType entity) throws FunctionalException {
		return updateServiceHelper.update(entity);
	}

	@Override
	public SexType updateAndReturn(SexType entity) throws FunctionalException {
		return updateServiceHelper.updateAndReturn(entity);
	}
	
	@Override
	public List<Integer> update(Collection<SexType> entities) throws FunctionalException {
		return updateServiceHelper.update(entities);
	}
	
	@Override
	public List<SexType> updateAndReturn(Collection<SexType> entities) throws FunctionalException {
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
