package com.hyperbank.maps.country.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.country.dto.CountryDto;
import com.hyperbank.maps.country.entity.Country;
import com.hyperbank.maps.country.mapper.CountryMapper;
import com.hyperbank.maps.country.repository.CountryRepository;
import com.hyperbank.maps.country.service.CountryService;
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
public class CountryServiceImpl implements CountryService {

	public CountryServiceImpl(CountryMapper countryMapper, CountryRepository countryRepository) {
		readService = new ReadServiceImpl<>(countryMapper, countryRepository, Country.class);
		createService = new CreateServiceImpl<>(countryMapper, countryRepository, Country.class);
		updateService = new UpdateServiceImpl<>(
				countryMapper,
				countryRepository,
				readService,
				Country.class,
				CountryDto.class);
		deleteService = new DeleteServiceImpl<>(countryRepository, readService);
	}

	private final ReadService<Integer, Country, CountryDto> readService;
	private final CreateService<Integer, CountryDto> createService;
	private final UpdateService<Integer, CountryDto> updateService;
	private final DeleteService<Integer> deleteService;

	@Override
	@Transactional(readOnly = true)
	public Country findById(Integer id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public CountryDto findByIdToDto(Integer id) throws FunctionalException {
		return readService.findByIdToDto(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Country> findManyById(Collection<Integer> ids) {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<CountryDto> findManyByIdToDto(Collection<Integer> ids) {
		return readService.findManyByIdToDto(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Country> findAll() {
		return readService.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<CountryDto> findAllToDto() {
		return readService.findAllToDto();
	}

	@Override
	public Integer save(CountryDto dto) throws TechnicalException {
		return createService.save(dto);
	}

	@Override
	public Collection<Integer> save(Collection<CountryDto> dtos) throws TechnicalException {
		return createService.save(dtos);
	}

	@Override
	public Integer update(CountryDto dto) throws FunctionalException, TechnicalException {
		return updateService.update(dto);
	}

	@Override
	public Collection<Integer> update(Collection<CountryDto> dtos) throws FunctionalException, TechnicalException {
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
