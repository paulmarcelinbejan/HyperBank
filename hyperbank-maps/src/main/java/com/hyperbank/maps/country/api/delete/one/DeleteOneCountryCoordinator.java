package com.hyperbank.maps.country.api.delete.one;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface DeleteOneCountryCoordinator extends CoordinatorRequestAware<Integer> {
	
	/**
	 * Delete country by ID
	 */
	@Override
	void process(Integer id) throws FunctionalException, TechnicalException;

}
