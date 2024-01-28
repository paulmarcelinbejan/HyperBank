package com.hyperbank.maps.location.api.update.one;

import com.hyperbank.maps.location.dto.LocationResponse;
import com.hyperbank.maps.location.dto.LocationUpdateRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface UpdateOneLocationCoordinator extends CoordinatorRequestResponseAware<LocationUpdateRequest, LocationResponse> {
	
	/**
	 * Update location by request
	 */
	@Override
	LocationResponse process(LocationUpdateRequest request) throws FunctionalException, TechnicalException;
	
}
