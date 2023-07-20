package com.hyperbank.maps.location.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.location.dto.LocationDto;
import com.hyperbank.maps.location.entity.Location;
import com.hyperbank.maps.location.mapper.LocationMapper;
import com.hyperbank.maps.location.repository.LocationRepository;
import com.hyperbank.maps.location.service.LocationService;
import com.paulmarcelinbejan.toolbox.exception.technical.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.web.service.CreateService;
import com.paulmarcelinbejan.toolbox.web.service.DeleteService;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;
import com.paulmarcelinbejan.toolbox.web.service.UpdateService;
import com.paulmarcelinbejan.toolbox.web.service.impl.CreateServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.impl.DeleteServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.impl.ReadServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.impl.UpdateServiceImpl;

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class LocationServiceImpl implements LocationService {

	public LocationServiceImpl(LocationMapper locationMapper, LocationRepository locationRepository) {
		readService = new ReadServiceImpl<>(locationMapper, locationRepository, Location.class);
		createService = new CreateServiceImpl<>(locationMapper, locationRepository, Location.class);
		updateService = new UpdateServiceImpl<>(
				locationMapper,
				locationRepository,
				readService,
				Location.class,
				LocationDto.class);
		deleteService = new DeleteServiceImpl<>(locationRepository, readService);
	}

	private final ReadService<Long, Location, LocationDto> readService;
	private final CreateService<Long, LocationDto> createService;
	private final UpdateService<Long, LocationDto> updateService;
	private final DeleteService<Long> deleteService;

	@Override
	public Location findById(Long id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	public LocationDto findByIdToDto(Long id) throws FunctionalException {
		return readService.findByIdToDto(id);
	}

	/**
	 * If some or all ids are not found, no entities are returned for these IDs.
	 */
	@Override
	public Collection<Location> findManyById(Collection<Long> ids) {
		return readService.findManyById(ids);
	}

	/**
	 * If some or all ids are not found, no DTOs are returned for these IDs.
	 */
	@Override
	public Collection<LocationDto> findManyByIdToDto(Collection<Long> ids) {
		return readService.findManyByIdToDto(ids);
	}

	@Override
	public Collection<Location> findAll() {
		return readService.findAll();
	}

	@Override
	public Collection<LocationDto> findAllToDto() {
		return readService.findAllToDto();
	}

	@Override
	public Long save(LocationDto dto) throws TechnicalException {
		return createService.save(dto);
	}

	@Override
	public Collection<Long> save(Collection<LocationDto> dtos) throws TechnicalException {
		return createService.save(dtos);
	}

	@Override
	public Long update(LocationDto dto) throws FunctionalException, TechnicalException {
		return updateService.update(dto);
	}

	@Override
	public Collection<Long> update(Collection<LocationDto> dtos) throws FunctionalException, TechnicalException {
		return updateService.update(dtos);
	}

	@Override
	public void delete(Long id) throws FunctionalException {
		deleteService.delete(id);
	}

	/**
	 * If an Entity is not found in the persistence store, a FunctionalException
	 * will be thrown.
	 */
	@Override
	public void delete(Collection<Long> ids) throws FunctionalException {
		deleteService.delete(ids);
	}

	/**
	 * Entities that aren't found in the persistence store are silently ignored.
	 */
	@Override
	public void deleteIfPresent(Collection<Long> ids) {
		deleteService.deleteIfPresent(ids);
	}

}
