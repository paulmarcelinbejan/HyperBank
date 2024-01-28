package com.hyperbank.maps.location.api.find.many;

import java.util.List;

import com.hyperbank.maps.location.dto.LocationResponse;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindManyLocationCoordinator extends CoordinatorRequestResponseAware<List<Long>, List<LocationResponse>> {

	/**
	 * Find many location by IDs
	 */
	@Override
	List<LocationResponse> process(List<Long> ids) throws FunctionalException, TechnicalException;

}
