package com.hyperbank.maps.continent.api.find.many;

import java.util.List;

import com.hyperbank.maps.continent.dto.ContinentResponse;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindManyContinentCoordinator extends CoordinatorRequestResponseAware<List<Integer>, List<ContinentResponse>> {

	/**
	 * Find many continent by IDs
	 */
	@Override
	List<ContinentResponse> process(List<Integer> ids) throws FunctionalException, TechnicalException;

}
