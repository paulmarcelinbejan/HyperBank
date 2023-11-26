package com.hyperbank.maps.continent.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.continent.entity.Continent;
import com.hyperbank.maps.continent.mapper.ContinentMapper;
import com.hyperbank.maps.continent.repository.ContinentRepository;
import com.hyperbank.maps.continent.service.ContinentService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.service.helper.CreateServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.DeleteServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.UpdateServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.impl.CreateServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.impl.DeleteServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.impl.ReadServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.impl.UpdateServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.utils.ServiceHelperUtils;

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class ContinentServiceImpl implements ContinentService {

	public ContinentServiceImpl(ContinentMapper continentMapper, ContinentRepository continentRepository) {
		createServiceHelper = new CreateServiceHelperImpl<>(continentRepository, Continent::getId);
		readServiceHelper = new ReadServiceHelperImpl<>(continentRepository, ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(Continent.class));
		updateServiceHelper = new UpdateServiceHelperImpl<>(
				continentRepository,
				continentMapper,
				readServiceHelper,
				Continent::getId);
		deleteServiceHelper = new DeleteServiceHelperImpl<>(continentRepository, readServiceHelper);
	}

	private final CreateServiceHelper<Integer, Continent> createServiceHelper;
	private final ReadServiceHelper<Integer, Continent> readServiceHelper;
	private final UpdateServiceHelper<Integer, Continent> updateServiceHelper;
	private final DeleteServiceHelper<Integer> deleteServiceHelper;

	@Override
	@Transactional(readOnly = true)
	public Continent getReferenceById(Integer id) {
		return readServiceHelper.getReferenceById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Continent findById(Integer id) throws FunctionalException {
		return readServiceHelper.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Continent> findManyById(List<Integer> ids) throws FunctionalException {
		return readServiceHelper.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Continent> findManyByIdIfPresent(List<Integer> ids) {
		return readServiceHelper.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Continent> findAll() {
		return readServiceHelper.findAll();
	}

	@Override
	public Integer save(Continent entity) throws FunctionalException {
		return createServiceHelper.save(entity);
	}

	@Override
	public Continent saveAndReturn(Continent entity) throws FunctionalException {
		return createServiceHelper.saveAndReturn(entity);
	}

	@Override
	public List<Integer> save(List<Continent> entities) throws FunctionalException {
		return createServiceHelper.save(entities);
	}

	@Override
	public List<Continent> saveAndReturn(List<Continent> entities) throws FunctionalException {
		return createServiceHelper.saveAndReturn(entities);
	}

	@Override
	public Integer update(Continent entity) throws FunctionalException {
		return updateServiceHelper.update(entity);
	}

	@Override
	public Continent updateAndReturn(Continent entity) throws FunctionalException {
		return updateServiceHelper.updateAndReturn(entity);
	}
	
	@Override
	public List<Integer> update(List<Continent> entities) throws FunctionalException {
		return updateServiceHelper.update(entities);
	}
	
	@Override
	public List<Continent> updateAndReturn(List<Continent> entities) throws FunctionalException {
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
	public void deleteMany(List<Integer> ids) throws FunctionalException {
		deleteServiceHelper.deleteMany(ids);
	}

	@Override
	public void deleteManyIfPresent(List<Integer> ids) {
		deleteServiceHelper.deleteManyIfPresent(ids);
	}
	
}
