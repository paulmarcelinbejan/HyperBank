package com.hyperbank.maps.country.api.delete.one;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface DeleteOneCountryService extends ServiceInputAware<Integer> {

	/**
	 * Delete country by ID
	 */
	@Override
	void execute(Integer id) throws FunctionalException, TechnicalException;
	
}
