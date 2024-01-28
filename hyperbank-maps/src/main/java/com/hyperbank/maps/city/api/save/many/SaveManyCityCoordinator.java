package com.hyperbank.maps.city.api.save.many;

import java.util.List;

import com.hyperbank.maps.city.dto.CityResponse;
import com.hyperbank.maps.city.dto.CitySaveRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface SaveManyCityCoordinator extends CoordinatorRequestResponseAware<List<CitySaveRequest>, List<CityResponse>> {
	
	/**
	 * Save many city by requests
	 */
	@Override
	List<CityResponse> process(List<CitySaveRequest> requests) throws FunctionalException, TechnicalException;
	
}
