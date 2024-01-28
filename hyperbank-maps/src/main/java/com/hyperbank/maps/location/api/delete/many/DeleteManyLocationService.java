package com.hyperbank.maps.location.api.delete.many;

import java.util.List;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface DeleteManyLocationService extends ServiceInputAware<List<Long>> {

	/**
	 * Delete many location by IDs
	 */
	@Override
	void execute(List<Long> ids) throws FunctionalException, TechnicalException;
	
}
