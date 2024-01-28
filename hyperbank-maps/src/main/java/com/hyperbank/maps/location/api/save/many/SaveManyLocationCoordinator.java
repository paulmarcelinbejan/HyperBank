package com.hyperbank.maps.location.api.save.many;

import java.util.List;

import com.hyperbank.maps.location.dto.LocationResponse;
import com.hyperbank.maps.location.dto.LocationSaveRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface SaveManyLocationCoordinator extends CoordinatorRequestResponseAware<List<LocationSaveRequest>, List<LocationResponse>> {
	
	/**
	 * Save many location by requests
	 */
	@Override
	List<LocationResponse> process(List<LocationSaveRequest> requests) throws FunctionalException, TechnicalException;
	
}
