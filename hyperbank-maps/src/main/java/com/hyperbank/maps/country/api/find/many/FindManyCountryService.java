package com.hyperbank.maps.country.api.find.many;

import java.util.List;

import com.hyperbank.maps.country.entity.Country;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindManyCountryService extends ServiceInputOutputAware<List<Integer>, List<Country>> {

	/**
	 * Find many country by IDs
	 */
	@Override
	List<Country> execute(List<Integer> ids) throws FunctionalException, TechnicalException;
	
}
