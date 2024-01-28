package com.hyperbank.maps.country.api.save.one;

import com.hyperbank.maps.country.entity.Country;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface SaveOneCountryService extends ServiceInputOutputAware<Country, Country> {

	/**
	 * Save country
	 */
	@Override
	Country execute(Country country) throws FunctionalException, TechnicalException;
	
}
