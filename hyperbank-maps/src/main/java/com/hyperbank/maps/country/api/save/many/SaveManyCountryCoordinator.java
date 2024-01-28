package com.hyperbank.maps.country.api.save.many;

import java.util.List;

import com.hyperbank.maps.country.dto.CountryResponse;
import com.hyperbank.maps.country.dto.CountrySaveRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface SaveManyCountryCoordinator extends CoordinatorRequestResponseAware<List<CountrySaveRequest>, List<CountryResponse>> {
	
	/**
	 * Save many country by requests
	 */
	@Override
	List<CountryResponse> process(List<CountrySaveRequest> requests) throws FunctionalException, TechnicalException;
	
}
