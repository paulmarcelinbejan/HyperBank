package com.hyperbank.maps.continent.api.find.one;

import com.hyperbank.maps.continent.dto.ContinentResponse;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindOneContinentCoordinator extends CoordinatorRequestResponseAware<Integer, ContinentResponse> {
	
	/**
	 * Find continent by id
	 */
	@Override
	ContinentResponse process(Integer id) throws FunctionalException, TechnicalException;
	
}
