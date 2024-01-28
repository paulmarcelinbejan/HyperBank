package com.hyperbank.maps.country.api.save.one;

import com.hyperbank.maps.country.dto.CountryResponse;
import com.hyperbank.maps.country.dto.CountrySaveRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface SaveOneCountryCoordinator extends CoordinatorRequestResponseAware<CountrySaveRequest, CountryResponse> {
	
	/**
	 * Save country by request
	 */
	@Override
	CountryResponse process(CountrySaveRequest request) throws FunctionalException, TechnicalException;
	
}
