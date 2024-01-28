package com.hyperbank.maps.continent.api.find.one;

import com.hyperbank.maps.continent.entity.Continent;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;

public interface FindOneContinentService extends ServiceInputOutputAware<Integer, Continent> {

	/**
	 * Find continent by ID
	 */
	@Override
	Continent execute(Integer id) throws FunctionalException;
	
}
