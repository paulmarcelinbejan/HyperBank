package com.hyperbank.maps.city.api.find.one;

import com.hyperbank.maps.city.dto.CityResponse;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindOneCityCoordinator extends CoordinatorRequestResponseAware<Integer, CityResponse> {
	
	/**
	 * Find city by id
	 */
	@Override
	CityResponse process(Integer id) throws FunctionalException, TechnicalException;
	
}
