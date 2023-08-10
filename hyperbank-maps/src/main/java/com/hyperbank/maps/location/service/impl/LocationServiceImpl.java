package com.hyperbank.maps.location.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.location.dto.LocationDto;
import com.hyperbank.maps.location.entity.Location;
import com.hyperbank.maps.location.mapper.LocationMapper;
import com.hyperbank.maps.location.repository.LocationRepository;
import com.hyperbank.maps.location.service.LocationService;
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
public class LocationServiceImpl implements LocationService {

	public LocationServiceImpl(LocationMapper locationMapper, LocationRepository locationRepository) {
		createService = new CreateServiceImpl<>(locationMapper, locationRepository, Location::getId);
		readService = new ReadServiceImpl<>(locationMapper, locationRepository, ServiceUtils.buildErrorMessageIfEntityNotFound(Location.class));
		updateService = new UpdateServiceImpl<>(
				locationMapper,
				locationRepository,
				readService,
				Location::getId,
				LocationDto::getId);
		deleteService = new DeleteServiceImpl<>(locationRepository, readService);
	}

	private final CreateService<Long, LocationDto> createService;
	private final ReadService<Long, Location, LocationDto> readService;
	private final UpdateService<Long, LocationDto> updateService;
	private final DeleteService<Long> deleteService;

	@Override
	@Transactional(readOnly = true)
	public Location findById(Long id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public LocationDto findByIdToDto(Long id) throws FunctionalException {
		return readService.findByIdToDto(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Location> findManyById(Collection<Long> ids) throws FunctionalException {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Location> findManyByIdIfPresent(Collection<Long> ids) {
		return readService.findManyByIdIfPresent(ids);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Collection<LocationDto> findManyByIdToDto(Collection<Long> ids) throws FunctionalException {
		return readService.findManyByIdToDto(ids);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Collection<LocationDto> findManyByIdToDtoIfPresent(Collection<Long> ids) {
		return readService.findManyByIdToDtoIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Location> findAll() {
		return readService.findAll();
	}

	@Override
	@Transactional(readOnly = true)
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
	public LocationDto updateAndReturn(LocationDto dto) throws FunctionalException, TechnicalException {
		return updateService.updateAndReturn(dto);
	}
	
	@Override
	public Collection<Long> update(Collection<LocationDto> dtos) throws FunctionalException, TechnicalException {
		return updateService.update(dtos);
	}
	
	@Override
	public Collection<LocationDto> updateAndReturn(Collection<LocationDto> dtos) throws FunctionalException, TechnicalException {
		return updateService.updateAndReturn(dtos);
	}

	@Override
	public void delete(Long id) throws FunctionalException {
		deleteService.delete(id);
	}
	
	@Override
	public void deleteIfPresent(Long id) throws FunctionalException {
		deleteService.deleteIfPresent(id);
	}

	@Override
	public void delete(Collection<Long> ids) throws FunctionalException {
		deleteService.delete(ids);
	}

	@Override
	public void deleteIfPresent(Collection<Long> ids) {
		deleteService.deleteIfPresent(ids);
	}
	
}
