package com.hyperbank.maps.continent.api.update.one;

import com.hyperbank.maps.continent.dto.ContinentResponse;
import com.hyperbank.maps.continent.dto.ContinentUpdateRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface UpdateOneContinentCoordinator extends CoordinatorRequestResponseAware<ContinentUpdateRequest, ContinentResponse> {
	
	/**
	 * Update continent by request
	 */
	@Override
	ContinentResponse process(ContinentUpdateRequest request) throws FunctionalException, TechnicalException;
	
}
