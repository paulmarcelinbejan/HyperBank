package com.hyperbank.maps.city.api.update.one;

import com.hyperbank.maps.city.dto.CityResponse;
import com.hyperbank.maps.city.dto.CityUpdateRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface UpdateOneCityCoordinator extends CoordinatorRequestResponseAware<CityUpdateRequest, CityResponse> {
	
	/**
	 * Update city by request
	 */
	@Override
	CityResponse process(CityUpdateRequest request) throws FunctionalException, TechnicalException;
	
}
