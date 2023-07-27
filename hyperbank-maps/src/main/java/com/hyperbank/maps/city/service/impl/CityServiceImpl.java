package com.hyperbank.maps.city.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.city.dto.CityDto;
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

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class CityServiceImpl implements CityService {

	public CityServiceImpl(CityMapper cityMapper, CityRepository cityRepository) {
		readService = new ReadServiceImpl<>(cityMapper, cityRepository, City.class);
		createService = new CreateServiceImpl<>(cityMapper, cityRepository, City.class);
		updateService = new UpdateServiceImpl<>(
				cityMapper,
				cityRepository,
				readService,
				City.class,
				CityDto.class);
		deleteService = new DeleteServiceImpl<>(cityRepository, readService);
	}

	private final ReadService<Integer, City, CityDto> readService;
	private final CreateService<Integer, CityDto> createService;
	private final UpdateService<Integer, CityDto> updateService;
	private final DeleteService<Integer> deleteService;

	@Override
	@Transactional(readOnly = true)
	public City findById(Integer id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public CityDto findByIdToDto(Integer id) throws FunctionalException {
		return readService.findByIdToDto(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<City> findManyById(Collection<Integer> ids) {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<CityDto> findManyByIdToDto(Collection<Integer> ids) {
		return readService.findManyByIdToDto(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<City> findAll() {
		return readService.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<CityDto> findAllToDto() {
		return readService.findAllToDto();
	}

	@Override
	public Integer save(CityDto dto) throws TechnicalException {
		return createService.save(dto);
	}

	@Override
	public Collection<Integer> save(Collection<CityDto> dtos) throws TechnicalException {
		return createService.save(dtos);
	}

	@Override
	public Integer update(CityDto dto) throws FunctionalException, TechnicalException {
		return updateService.update(dto);
	}

	@Override
	public Collection<Integer> update(Collection<CityDto> dtos) throws FunctionalException, TechnicalException {
		return updateService.update(dtos);
	}

	@Override
	public void delete(Integer id) throws FunctionalException {
		deleteService.delete(id);
	}

	/**
	 * If an Entity is not found in the persistence store, a FunctionalException
	 * will be thrown.
	 */
	@Override
	public void delete(Collection<Integer> ids) throws FunctionalException {
		deleteService.delete(ids);
	}

	/**
	 * Entities that aren't found in the persistence store are silently ignored.
	 */
	@Override
	public void deleteIfPresent(Collection<Integer> ids) {
		deleteService.deleteIfPresent(ids);
	}

}
