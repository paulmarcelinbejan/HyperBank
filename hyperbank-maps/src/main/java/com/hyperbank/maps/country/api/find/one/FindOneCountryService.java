package com.hyperbank.maps.country.api.find.one;

import com.hyperbank.maps.country.entity.Country;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;

public interface FindOneCountryService extends ServiceInputOutputAware<Integer, Country> {

	/**
	 * Find country by ID
	 */
	@Override
	Country execute(Integer id) throws FunctionalException;
	
}
