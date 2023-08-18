package com.hyperbank.commons.sextype.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.commons.sextype.entity.SexType;
import com.hyperbank.commons.sextype.mapper.SexTypeMapper;
import com.hyperbank.commons.sextype.repository.SexTypeRepository;
import com.hyperbank.commons.sextype.service.SexTypeService;
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
public class SexTypeServiceImpl implements SexTypeService {

	public SexTypeServiceImpl(SexTypeMapper sexTypeMapper, SexTypeRepository sexTypeRepository) {
		createService = new CreateServiceImpl<>(sexTypeRepository, SexType::getId);
		readService = new ReadServiceImpl<>(sexTypeRepository, ServiceUtils.buildErrorMessageIfEntityNotFoundById(SexType.class));
		updateService = new UpdateServiceImpl<>(
				sexTypeRepository,
				sexTypeMapper,
				readService,
				SexType::getId);
		deleteService = new DeleteServiceImpl<>(sexTypeRepository, readService);
	}

	private final CreateService<Integer, SexType> createService;
	private final ReadService<Integer, SexType> readService;
	private final UpdateService<Integer, SexType> updateService;
	private final DeleteService<Integer> deleteService;

	@Override
	@Transactional(readOnly = true)
	public SexType getReferenceById(Integer id) {
		return readService.getReferenceById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public SexType findById(Integer id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<SexType> findManyById(Collection<Integer> ids) throws FunctionalException {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<SexType> findManyByIdIfPresent(Collection<Integer> ids) {
		return readService.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<SexType> findAll() {
		return readService.findAll();
	}

	@Override
	public Integer save(SexType entity) {
		return createService.save(entity);
	}

	@Override
	public SexType saveAndReturn(SexType entity) {
		return createService.saveAndReturn(entity);
	}

	@Override
	public Collection<Integer> save(Collection<SexType> entities) {
		return createService.save(entities);
	}

	@Override
	public Collection<SexType> saveAndReturn(Collection<SexType> entities) {
		return createService.saveAndReturn(entities);
	}

	@Override
	public Integer update(SexType entity) throws FunctionalException {
		return updateService.update(entity);
	}

	@Override
	public SexType updateAndReturn(SexType entity) throws FunctionalException {
		return updateService.updateAndReturn(entity);
	}
	
	@Override
	public Collection<Integer> update(Collection<SexType> entities) throws FunctionalException {
		return updateService.update(entities);
	}
	
	@Override
	public Collection<SexType> updateAndReturn(Collection<SexType> entities) throws FunctionalException {
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
