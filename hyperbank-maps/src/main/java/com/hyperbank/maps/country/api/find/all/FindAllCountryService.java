package com.hyperbank.maps.country.api.find.all;

import java.util.List;

import com.hyperbank.maps.country.entity.Country;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindAllCountryService extends ServiceOutputAware<List<Country>> {

	/**
	 * Find all country
	 */
	@Override
	List<Country> execute() throws FunctionalException, TechnicalException;
	
}
