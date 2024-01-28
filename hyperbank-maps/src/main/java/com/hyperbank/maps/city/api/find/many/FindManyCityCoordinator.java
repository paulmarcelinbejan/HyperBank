package com.hyperbank.maps.city.api.find.many;

import java.util.List;

import com.hyperbank.maps.city.dto.CityResponse;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindManyCityCoordinator extends CoordinatorRequestResponseAware<List<Integer>, List<CityResponse>> {

	/**
	 * Find many city by IDs
	 */
	@Override
	List<CityResponse> process(List<Integer> ids) throws FunctionalException, TechnicalException;

}
