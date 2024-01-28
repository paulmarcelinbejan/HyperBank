package com.hyperbank.maps.continent.api.save.one;

import com.hyperbank.maps.continent.dto.ContinentResponse;
import com.hyperbank.maps.continent.dto.ContinentSaveRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface SaveOneContinentCoordinator extends CoordinatorRequestResponseAware<ContinentSaveRequest, ContinentResponse> {
	
	/**
	 * Save continent by request
	 */
	@Override
	ContinentResponse process(ContinentSaveRequest request) throws FunctionalException, TechnicalException;
	
}
