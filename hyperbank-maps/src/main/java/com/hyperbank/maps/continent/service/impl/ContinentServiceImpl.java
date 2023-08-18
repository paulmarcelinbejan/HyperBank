package com.hyperbank.maps.continent.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.continent.entity.Continent;
import com.hyperbank.maps.continent.mapper.ContinentMapper;
import com.hyperbank.maps.continent.repository.ContinentRepository;
import com.hyperbank.maps.continent.service.ContinentService;
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
public class ContinentServiceImpl implements ContinentService {

	public ContinentServiceImpl(ContinentMapper continentMapper, ContinentRepository continentRepository) {
		createService = new CreateServiceImpl<>(continentRepository, Continent::getId);
		readService = new ReadServiceImpl<>(continentRepository, ServiceUtils.buildErrorMessageIfEntityNotFoundById(Continent.class));
		updateService = new UpdateServiceImpl<>(
				continentRepository,
				continentMapper,
				readService,
				Continent::getId);
		deleteService = new DeleteServiceImpl<>(continentRepository, readService);
	}

	private final CreateService<Integer, Continent> createService;
	private final ReadService<Integer, Continent> readService;
	private final UpdateService<Integer, Continent> updateService;
	private final DeleteService<Integer> deleteService;

	@Override
	@Transactional(readOnly = true)
	public Continent getReferenceById(Integer id) {
		return readService.getReferenceById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Continent findById(Integer id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Continent> findManyById(Collection<Integer> ids) throws FunctionalException {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Continent> findManyByIdIfPresent(Collection<Integer> ids) {
		return readService.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Continent> findAll() {
		return readService.findAll();
	}

	@Override
	public Integer save(Continent entity) {
		return createService.save(entity);
	}
	
	@Override
	public Continent saveAndReturn(Continent entity) {
		return createService.saveAndReturn(entity);
	}

	@Override
	public Collection<Integer> save(Collection<Continent> entities) {
		return createService.save(entities);
	}
	
	@Override
	public Collection<Continent> saveAndReturn(Collection<Continent> entities) {
		return createService.saveAndReturn(entities);
	}

	@Override
	public Integer update(Continent entity) throws FunctionalException {
		return updateService.update(entity);
	}

	@Override
	public Continent updateAndReturn(Continent entity) throws FunctionalException {
		return updateService.updateAndReturn(entity);
	}
	
	@Override
	public Collection<Integer> update(Collection<Continent> entities) throws FunctionalException {
		return updateService.update(entities);
	}
	
	@Override
	public Collection<Continent> updateAndReturn(Collection<Continent> entities) throws FunctionalException {
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
