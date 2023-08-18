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
import com.paulmarcelinbejan.toolbox.web.service.utils.ServiceUtils;

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class CityServiceImpl implements CityService {

	public CityServiceImpl(CityMapper cityMapper, CityRepository cityRepository) {
		createService = new CreateServiceImpl<>(cityMapper, cityRepository, City::getId);
		readService = new ReadServiceImpl<>(cityMapper, cityRepository, ServiceUtils.buildErrorMessageIfEntityNotFound(City.class));
		updateService = new UpdateServiceImpl<>(
				cityMapper,
				cityRepository,
				readService,
				City::getId,
				CityDto::getId);
		deleteService = new DeleteServiceImpl<>(cityRepository, readService);
	}

	private final CreateService<Integer, CityDto> createService;
	private final ReadService<Integer, City, CityDto> readService;
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
	public Collection<CityDto> findManyByIdToDto(Collection<Integer> ids) throws FunctionalException {
		return readService.findManyByIdToDto(ids);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Collection<CityDto> findManyByIdToDtoIfPresent(Collection<Integer> ids) {
		return readService.findManyByIdToDtoIfPresent(ids);
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
	public CityDto updateAndReturn(CityDto dto) throws FunctionalException, TechnicalException {
		return updateService.updateAndReturn(dto);
	}
	
	@Override
	public Collection<Integer> update(Collection<CityDto> dtos) throws FunctionalException, TechnicalException {
		return updateService.update(dtos);
	}
	
	@Override
	public Collection<CityDto> updateAndReturn(Collection<CityDto> dtos) throws FunctionalException, TechnicalException {
		return updateService.updateAndReturn(dtos);
	}

	@Override
	public void delete(Integer id) throws FunctionalException {
		deleteService.delete(id);
	}
	
	@Override
	public void deleteIfPresent(Integer id) throws FunctionalException {
		deleteService.deleteIfPresent(id);
	}

	@Override
	public void delete(Collection<Integer> ids) throws FunctionalException {
		deleteService.delete(ids);
	}

	@Override
	public void deleteIfPresent(Collection<Integer> ids) {
		deleteService.deleteIfPresent(ids);
	}
	
}