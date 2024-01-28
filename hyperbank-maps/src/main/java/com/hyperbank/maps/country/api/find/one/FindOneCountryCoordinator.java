package com.hyperbank.maps.country.api.find.one;

import com.hyperbank.maps.country.dto.CountryResponse;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindOneCountryCoordinator extends CoordinatorRequestResponseAware<Integer, CountryResponse> {
	
	/**
	 * Find country by id
	 */
	@Override
	CountryResponse process(Integer id) throws FunctionalException, TechnicalException;
	
}
