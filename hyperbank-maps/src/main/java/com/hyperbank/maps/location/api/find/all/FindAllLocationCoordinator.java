package com.hyperbank.maps.location.api.find.all;

import java.util.List;

import com.hyperbank.maps.location.dto.LocationResponse;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindAllLocationCoordinator extends CoordinatorResponseAware<List<LocationResponse>> {

	/**
	 * Find all location
	 */
	@Override
	List<LocationResponse> process() throws FunctionalException, TechnicalException;
	
}
