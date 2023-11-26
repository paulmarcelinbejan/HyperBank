package com.hyperbank.maps.location.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.location.entity.Location;
import com.hyperbank.maps.location.mapper.LocationMapper;
import com.hyperbank.maps.location.repository.LocationRepository;
import com.hyperbank.maps.location.service.LocationService;
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
public class LocationServiceImpl implements LocationService {

	public LocationServiceImpl(LocationMapper locationMapper, LocationRepository locationRepository) {
		createServiceHelper = new CreateServiceHelperImpl<>(locationRepository, Location::getId);
		readServiceHelper = new ReadServiceHelperImpl<>(locationRepository, ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(Location.class));
		updateServiceHelper = new UpdateServiceHelperImpl<>(
				locationRepository,
				locationMapper,
				readServiceHelper,
				Location::getId);
		deleteServiceHelper = new DeleteServiceHelperImpl<>(locationRepository, readServiceHelper);
	}

	private final CreateServiceHelper<Long, Location> createServiceHelper;
	private final ReadServiceHelper<Long, Location> readServiceHelper;
	private final UpdateServiceHelper<Long, Location> updateServiceHelper;
	private final DeleteServiceHelper<Long> deleteServiceHelper;

	@Override
	@Transactional(readOnly = true)
	public Location getReferenceById(Long id) {
		return readServiceHelper.getReferenceById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Location findById(Long id) throws FunctionalException {
		return readServiceHelper.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Location> findManyById(Collection<Long> ids) throws FunctionalException {
		return readServiceHelper.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Location> findManyByIdIfPresent(Collection<Long> ids) {
		return readServiceHelper.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Location> findAll() {
		return readServiceHelper.findAll();
	}

	@Override
	public Long save(Location entity) throws FunctionalException {
		return createServiceHelper.save(entity);
	}
	
	@Override
	public Location saveAndReturn(Location entity) throws FunctionalException {
		return createServiceHelper.saveAndReturn(entity);
	}

	@Override
	public List<Long> save(Collection<Location> entities) throws FunctionalException {
		return createServiceHelper.save(entities);
	}
	
	@Override
	public List<Location> saveAndReturn(Collection<Location> entities) throws FunctionalException {
		return createServiceHelper.saveAndReturn(entities);
	}

	@Override
	public Long update(Location entity) throws FunctionalException {
		return updateServiceHelper.update(entity);
	}

	@Override
	public Location updateAndReturn(Location entity) throws FunctionalException {
		return updateServiceHelper.updateAndReturn(entity);
	}
	
	@Override
	public List<Long> update(Collection<Location> entities) throws FunctionalException {
		return updateServiceHelper.update(entities);
	}
	
	@Override
	public List<Location> updateAndReturn(Collection<Location> entities) throws FunctionalException {
		return updateServiceHelper.updateAndReturn(entities);
	}

	@Override
	public void delete(Long id) throws FunctionalException {
		deleteServiceHelper.delete(id);
	}
	
	@Override
	public void deleteIfPresent(Long id) {
		deleteServiceHelper.deleteIfPresent(id);
	}

	@Override
	public void deleteMany(Collection<Long> ids) throws FunctionalException {
		deleteServiceHelper.deleteMany(ids);
	}

	@Override
	public void deleteManyIfPresent(Collection<Long> ids) {
		deleteServiceHelper.deleteManyIfPresent(ids);
	}
	
}
