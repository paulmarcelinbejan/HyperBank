package com.hyperbank.maps.location.api.delete.one;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface DeleteOneLocationCoordinator extends CoordinatorRequestAware<Long> {
	
	/**
	 * Delete location by ID
	 */
	@Override
	void process(Long id) throws FunctionalException, TechnicalException;

}
