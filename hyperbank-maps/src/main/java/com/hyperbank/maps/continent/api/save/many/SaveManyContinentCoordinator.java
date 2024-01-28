package com.hyperbank.maps.continent.api.save.many;

import java.util.List;

import com.hyperbank.maps.continent.dto.ContinentResponse;
import com.hyperbank.maps.continent.dto.ContinentSaveRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface SaveManyContinentCoordinator extends CoordinatorRequestResponseAware<List<ContinentSaveRequest>, List<ContinentResponse>> {
	
	/**
	 * Save many continent by requests
	 */
	@Override
	List<ContinentResponse> process(List<ContinentSaveRequest> requests) throws FunctionalException, TechnicalException;
	
}
