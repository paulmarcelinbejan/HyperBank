package com.hyperbank.maps.continent.api.delete.one;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface DeleteOneContinentService extends ServiceInputAware<Integer> {

	/**
	 * Delete continent by ID
	 */
	@Override
	void execute(Integer id) throws FunctionalException, TechnicalException;
	
}
