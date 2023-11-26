package com.hyperbank.maps.country.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.country.entity.Country;
import com.hyperbank.maps.country.mapper.CountryMapper;
import com.hyperbank.maps.country.repository.CountryRepository;
import com.hyperbank.maps.country.service.CountryService;
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
public class CountryServiceImpl implements CountryService {

	public CountryServiceImpl(CountryMapper countryMapper, CountryRepository countryRepository) {
		createServiceHelper = new CreateServiceHelperImpl<>(countryRepository, Country::getId);
		readServiceHelper = new ReadServiceHelperImpl<>(countryRepository, ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(Country.class));
		updateServiceHelper = new UpdateServiceHelperImpl<>(
				countryRepository,
				countryMapper,
				readServiceHelper,
				Country::getId);
		deleteServiceHelper = new DeleteServiceHelperImpl<>(countryRepository, readServiceHelper);
	}

	private final CreateServiceHelper<Integer, Country> createServiceHelper;
	private final ReadServiceHelper<Integer, Country> readServiceHelper;
	private final UpdateServiceHelper<Integer, Country> updateServiceHelper;
	private final DeleteServiceHelper<Integer> deleteServiceHelper;

	@Override
	@Transactional(readOnly = true)
	public Country getReferenceById(Integer id) {
		return readServiceHelper.getReferenceById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Country findById(Integer id) throws FunctionalException {
		return readServiceHelper.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Country> findManyById(Collection<Integer> ids) throws FunctionalException {
		return readServiceHelper.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Country> findManyByIdIfPresent(Collection<Integer> ids) {
		return readServiceHelper.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Country> findAll() {
		return readServiceHelper.findAll();
	}

	@Override
	public Integer save(Country entity) throws FunctionalException {
		return createServiceHelper.save(entity);
	}
	
	@Override
	public Country saveAndReturn(Country entity) throws FunctionalException {
		return createServiceHelper.saveAndReturn(entity);
	}

	@Override
	public List<Integer> save(Collection<Country> entities) throws FunctionalException {
		return createServiceHelper.save(entities);
	}
	
	@Override
	public List<Country> saveAndReturn(Collection<Country> entities) throws FunctionalException {
		return createServiceHelper.saveAndReturn(entities);
	}

	@Override
	public Integer update(Country entity) throws FunctionalException {
		return updateServiceHelper.update(entity);
	}

	@Override
	public Country updateAndReturn(Country entity) throws FunctionalException {
		return updateServiceHelper.updateAndReturn(entity);
	}
	
	@Override
	public List<Integer> update(Collection<Country> entities) throws FunctionalException {
		return updateServiceHelper.update(entities);
	}
	
	@Override
	public List<Country> updateAndReturn(Collection<Country> entities) throws FunctionalException {
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
