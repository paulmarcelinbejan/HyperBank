package com.hyperbank.maps.city.api.delete.one;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface DeleteOneCityCoordinator extends CoordinatorRequestAware<Integer> {
	
	/**
	 * Delete city by ID
	 */
	@Override
	void process(Integer id) throws FunctionalException, TechnicalException;

}
