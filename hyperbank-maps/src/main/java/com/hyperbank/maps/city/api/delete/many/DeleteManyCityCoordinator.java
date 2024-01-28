package com.hyperbank.maps.city.api.delete.many;

import java.util.List;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface DeleteManyCityCoordinator extends CoordinatorRequestAware<List<Integer>> {
	
	/**
	 * Delete many city by IDs
	 */
	@Override
	void process(List<Integer> ids) throws FunctionalException, TechnicalException;
	
}
