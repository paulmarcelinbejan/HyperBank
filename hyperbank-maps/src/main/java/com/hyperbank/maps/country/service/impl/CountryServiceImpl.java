package com.hyperbank.maps.country.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.paulmarcelinbejan.toolbox.web.service.utils.ServiceUtils;

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class CountryServiceImpl implements CountryService {

	public CountryServiceImpl(CountryMapper countryMapper, CountryRepository countryRepository) {
		createService = new CreateServiceImpl<>(countryRepository, Country::getId);
		readService = new ReadServiceImpl<>(countryRepository, ServiceUtils.buildErrorMessageIfEntityNotFoundById(Country.class));
		updateService = new UpdateServiceImpl<>(
				countryRepository,
				countryMapper,
				readService,
				Country::getId);
		deleteService = new DeleteServiceImpl<>(countryRepository, readService);
	}

	private final CreateService<Integer, Country> createService;
	private final ReadService<Integer, Country> readService;
	private final UpdateService<Integer, Country> updateService;
	private final DeleteService<Integer> deleteService;

	@Override
	@Transactional(readOnly = true)
	public Country getReferenceById(Integer id) {
		return readService.getReferenceById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Country findById(Integer id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Country> findManyById(Collection<Integer> ids) throws FunctionalException {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Country> findManyByIdIfPresent(Collection<Integer> ids) {
		return readService.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Country> findAll() {
		return readService.findAll();
	}

	@Override
	public Integer save(Country entity) {
		return createService.save(entity);
	}
	
	@Override
	public Country saveAndReturn(Country entity) {
		return createService.saveAndReturn(entity);
	}

	@Override
	public Collection<Integer> save(Collection<Country> entities) {
		return createService.save(entities);
	}
	
	@Override
	public Collection<Country> saveAndReturn(Collection<Country> entities) {
		return createService.saveAndReturn(entities);
	}

	@Override
	public Integer update(Country entity) throws FunctionalException {
		return updateService.update(entity);
	}

	@Override
	public Country updateAndReturn(Country entity) throws FunctionalException {
		return updateService.updateAndReturn(entity);
	}
	
	@Override
	public Collection<Integer> update(Collection<Country> entities) throws FunctionalException {
		return updateService.update(entities);
	}
	
	@Override
	public Collection<Country> updateAndReturn(Collection<Country> entities) throws FunctionalException {
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
