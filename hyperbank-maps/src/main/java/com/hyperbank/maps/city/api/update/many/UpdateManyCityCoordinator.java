package com.hyperbank.maps.city.api.update.many;

import java.util.List;

import com.hyperbank.maps.city.dto.CityResponse;
import com.hyperbank.maps.city.dto.CityUpdateRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface UpdateManyCityCoordinator extends CoordinatorRequestResponseAware<List<CityUpdateRequest>, List<CityResponse>> {
	
	/**
	 * Update many city by requests
	 */
	@Override
	List<CityResponse> process(List<CityUpdateRequest> requests) throws FunctionalException, TechnicalException;
	
}
