package com.hyperbank.maps.location.api.update.many;

import java.util.List;

import com.hyperbank.maps.location.dto.LocationResponse;
import com.hyperbank.maps.location.dto.LocationUpdateRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface UpdateManyLocationCoordinator extends CoordinatorRequestResponseAware<List<LocationUpdateRequest>, List<LocationResponse>> {
	
	/**
	 * Update many location by requests
	 */
	@Override
	List<LocationResponse> process(List<LocationUpdateRequest> requests) throws FunctionalException, TechnicalException;
	
}
