package com.hyperbank.maps.country.api.find.many;

import java.util.List;

import com.hyperbank.maps.country.dto.CountryResponse;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindManyCountryCoordinator extends CoordinatorRequestResponseAware<List<Integer>, List<CountryResponse>> {

	/**
	 * Find many country by IDs
	 */
	@Override
	List<CountryResponse> process(List<Integer> ids) throws FunctionalException, TechnicalException;

}
