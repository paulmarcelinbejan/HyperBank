package com.hyperbank.maps.location.api.save.one;

import com.hyperbank.maps.location.dto.LocationResponse;
import com.hyperbank.maps.location.dto.LocationSaveRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface SaveOneLocationCoordinator extends CoordinatorRequestResponseAware<LocationSaveRequest, LocationResponse> {
	
	/**
	 * Save location by request
	 */
	@Override
	LocationResponse process(LocationSaveRequest request) throws FunctionalException, TechnicalException;
	
}
