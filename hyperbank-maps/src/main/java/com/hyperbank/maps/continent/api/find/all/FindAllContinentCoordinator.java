package com.hyperbank.maps.continent.api.find.all;

import java.util.List;

import com.hyperbank.maps.continent.dto.ContinentResponse;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindAllContinentCoordinator extends CoordinatorResponseAware<List<ContinentResponse>> {

	/**
	 * Find all continent
	 */
	@Override
	List<ContinentResponse> process() throws FunctionalException, TechnicalException;
	
}
