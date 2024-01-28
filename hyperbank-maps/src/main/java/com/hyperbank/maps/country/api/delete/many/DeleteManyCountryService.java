package com.hyperbank.maps.country.api.delete.many;

import java.util.List;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface DeleteManyCountryService extends ServiceInputAware<List<Integer>> {

	/**
	 * Delete many country by IDs
	 */
	@Override
	void execute(List<Integer> ids) throws FunctionalException, TechnicalException;
	
}
