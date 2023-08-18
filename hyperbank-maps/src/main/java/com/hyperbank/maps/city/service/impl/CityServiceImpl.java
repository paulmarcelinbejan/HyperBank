package com.hyperbank.maps.city.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.city.entity.City;
import com.hyperbank.maps.city.mapper.CityMapper;
import com.hyperbank.maps.city.repository.CityRepository;
import com.hyperbank.maps.city.service.CityService;
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
public class CityServiceImpl implements CityService {

	public CityServiceImpl(CityMapper cityMapper, CityRepository cityRepository) {
		createService = new CreateServiceImpl<>(cityRepository, City::getId);
		readService = new ReadServiceImpl<>(cityRepository, ServiceUtils.buildErrorMessageIfEntityNotFoundById(City.class));
		updateService = new UpdateServiceImpl<>(
				cityRepository,
				cityMapper,
				readService,
				City::getId);
		deleteService = new DeleteServiceImpl<>(cityRepository, readService);
	}

	private final CreateService<Integer, City> createService;
	private final ReadService<Integer, City> readService;
	private final UpdateService<Integer, City> updateService;
	private final DeleteService<Integer> deleteService;

	@Override
	@Transactional(readOnly = true)
	public City getReferenceById(Integer id) {
		return readService.getReferenceById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public City findById(Integer id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<City> findManyById(Collection<Integer> ids) throws FunctionalException {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<City> findManyByIdIfPresent(Collection<Integer> ids) {
		return readService.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<City> findAll() {
		return readService.findAll();
	}

	@Override
	public Integer save(City entity) {
		return createService.save(entity);
	}
	
	@Override
	public City saveAndReturn(City entity) {
		return createService.saveAndReturn(entity);
	}

	@Override
	public Collection<Integer> save(Collection<City> entities) {
		return createService.save(entities);
	}
	
	@Override
	public Collection<City> saveAndReturn(Collection<City> entities) {
		return createService.saveAndReturn(entities);
	}

	@Override
	public Integer update(City entity) throws FunctionalException {
		return updateService.update(entity);
	}

	@Override
	public City updateAndReturn(City entity) throws FunctionalException {
		return updateService.updateAndReturn(entity);
	}
	
	@Override
	public Collection<Integer> update(Collection<City> entities) throws FunctionalException {
		return updateService.update(entities);
	}
	
	@Override
	public Collection<City> updateAndReturn(Collection<City> entities) throws FunctionalException {
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
