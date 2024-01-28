package com.hyperbank.maps.city.api.save.one;

import com.hyperbank.maps.city.dto.CityResponse;
import com.hyperbank.maps.city.dto.CitySaveRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface SaveOneCityCoordinator extends CoordinatorRequestResponseAware<CitySaveRequest, CityResponse> {
	
	/**
	 * Save city by request
	 */
	@Override
	CityResponse process(CitySaveRequest request) throws FunctionalException, TechnicalException;
	
}
