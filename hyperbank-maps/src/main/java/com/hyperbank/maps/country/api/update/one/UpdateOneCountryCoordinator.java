package com.hyperbank.maps.country.api.update.one;

import com.hyperbank.maps.country.dto.CountryResponse;
import com.hyperbank.maps.country.dto.CountryUpdateRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface UpdateOneCountryCoordinator extends CoordinatorRequestResponseAware<CountryUpdateRequest, CountryResponse> {
	
	/**
	 * Update country by request
	 */
	@Override
	CountryResponse process(CountryUpdateRequest request) throws FunctionalException, TechnicalException;
	
}
