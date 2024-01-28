package com.hyperbank.maps.city.api.delete.one;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface DeleteOneCityService extends ServiceInputAware<Integer> {

	/**
	 * Delete city by ID
	 */
	@Override
	void execute(Integer id) throws FunctionalException, TechnicalException;
	
}
