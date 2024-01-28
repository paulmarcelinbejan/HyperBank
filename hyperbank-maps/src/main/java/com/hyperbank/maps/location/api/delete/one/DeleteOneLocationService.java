package com.hyperbank.maps.location.api.delete.one;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface DeleteOneLocationService extends ServiceInputAware<Long> {

	/**
	 * Delete location by ID
	 */
	@Override
	void execute(Long id) throws FunctionalException, TechnicalException;
	
}
