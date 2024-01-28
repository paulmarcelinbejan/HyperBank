package com.hyperbank.maps.continent.api.delete.one;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface DeleteOneContinentCoordinator extends CoordinatorRequestAware<Integer> {
	
	/**
	 * Delete continent by ID
	 */
	@Override
	void process(Integer id) throws FunctionalException, TechnicalException;

}
