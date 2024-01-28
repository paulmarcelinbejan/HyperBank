package com.hyperbank.maps.continent.api.update.many;

import java.util.List;

import com.hyperbank.maps.continent.dto.ContinentResponse;
import com.hyperbank.maps.continent.dto.ContinentUpdateRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface UpdateManyContinentCoordinator extends CoordinatorRequestResponseAware<List<ContinentUpdateRequest>, List<ContinentResponse>> {
	
	/**
	 * Update many continent by requests
	 */
	@Override
	List<ContinentResponse> process(List<ContinentUpdateRequest> requests) throws FunctionalException, TechnicalException;
	
}
