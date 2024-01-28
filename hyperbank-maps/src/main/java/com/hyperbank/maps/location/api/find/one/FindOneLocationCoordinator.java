package com.hyperbank.maps.location.api.find.one;

import com.hyperbank.maps.location.dto.LocationResponse;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindOneLocationCoordinator extends CoordinatorRequestResponseAware<Long, LocationResponse> {
	
	/**
	 * Find location by id
	 */
	@Override
	LocationResponse process(Long id) throws FunctionalException, TechnicalException;
	
}
