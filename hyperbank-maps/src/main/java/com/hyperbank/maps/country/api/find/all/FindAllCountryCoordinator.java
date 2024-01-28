package com.hyperbank.maps.country.api.find.all;

import java.util.List;

import com.hyperbank.maps.country.dto.CountryResponse;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindAllCountryCoordinator extends CoordinatorResponseAware<List<CountryResponse>> {

	/**
	 * Find all country
	 */
	@Override
	List<CountryResponse> process() throws FunctionalException, TechnicalException;
	
}
