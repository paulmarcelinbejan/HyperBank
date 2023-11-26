package com.hyperbank.maps.city.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.city.entity.City;
import com.hyperbank.maps.city.mapper.CityMapper;
import com.hyperbank.maps.city.repository.CityRepository;
import com.hyperbank.maps.city.service.CityService;
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
public class CityServiceImpl implements CityService {

	public CityServiceImpl(CityMapper cityMapper, CityRepository cityRepository) {
		createServiceHelper = new CreateServiceHelperImpl<>(cityRepository, City::getId);
		readServiceHelper = new ReadServiceHelperImpl<>(cityRepository, ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(City.class));
		updateServiceHelper = new UpdateServiceHelperImpl<>(
				cityRepository,
				cityMapper,
				readServiceHelper,
				City::getId);
		deleteServiceHelper = new DeleteServiceHelperImpl<>(cityRepository, readServiceHelper);
	}

	private final CreateServiceHelper<Integer, City> createServiceHelper;
	private final ReadServiceHelper<Integer, City> readServiceHelper;
	private final UpdateServiceHelper<Integer, City> updateServiceHelper;
	private final DeleteServiceHelper<Integer> deleteServiceHelper;

	@Override
	@Transactional(readOnly = true)
	public City getReferenceById(Integer id) {
		return readServiceHelper.getReferenceById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public City findById(Integer id) throws FunctionalException {
		return readServiceHelper.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<City> findManyById(Collection<Integer> ids) throws FunctionalException {
		return readServiceHelper.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<City> findManyByIdIfPresent(Collection<Integer> ids) {
		return readServiceHelper.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<City> findAll() {
		return readServiceHelper.findAll();
	}

	@Override
	public Integer save(City entity) throws FunctionalException {
		return createServiceHelper.save(entity);
	}
	
	@Override
	public City saveAndReturn(City entity) throws FunctionalException {
		return createServiceHelper.saveAndReturn(entity);
	}

	@Override
	public List<Integer> save(Collection<City> entities) throws FunctionalException {
		return createServiceHelper.save(entities);
	}
	
	@Override
	public List<City> saveAndReturn(Collection<City> entities) throws FunctionalException {
		return createServiceHelper.saveAndReturn(entities);
	}

	@Override
	public Integer update(City entity) throws FunctionalException {
		return updateServiceHelper.update(entity);
	}

	@Override
	public City updateAndReturn(City entity) throws FunctionalException {
		return updateServiceHelper.updateAndReturn(entity);
	}
	
	@Override
	public List<Integer> update(Collection<City> entities) throws FunctionalException {
		return updateServiceHelper.update(entities);
	}
	
	@Override
	public List<City> updateAndReturn(Collection<City> entities) throws FunctionalException {
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
