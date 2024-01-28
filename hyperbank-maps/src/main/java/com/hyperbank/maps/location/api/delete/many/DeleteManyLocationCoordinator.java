package com.hyperbank.maps.location.api.delete.many;

import java.util.List;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface DeleteManyLocationCoordinator extends CoordinatorRequestAware<List<Long>> {
	
	/**
	 * Delete many location by IDs
	 */
	@Override
	void process(List<Long> ids) throws FunctionalException, TechnicalException;
	
}
