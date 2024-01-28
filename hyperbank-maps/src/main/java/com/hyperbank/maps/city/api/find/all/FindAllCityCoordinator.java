package com.hyperbank.maps.city.api.find.all;

import java.util.List;

import com.hyperbank.maps.city.dto.CityResponse;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindAllCityCoordinator extends CoordinatorResponseAware<List<CityResponse>> {

	/**
	 * Find all city
	 */
	@Override
	List<CityResponse> process() throws FunctionalException, TechnicalException;
	
}
