package com.hyperbank.maps.country.api.update.many;

import java.util.List;

import com.hyperbank.maps.country.dto.CountryResponse;
import com.hyperbank.maps.country.dto.CountryUpdateRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface UpdateManyCountryCoordinator extends CoordinatorRequestResponseAware<List<CountryUpdateRequest>, List<CountryResponse>> {
	
	/**
	 * Update many country by requests
	 */
	@Override
	List<CountryResponse> process(List<CountryUpdateRequest> requests) throws FunctionalException, TechnicalException;
	
}
