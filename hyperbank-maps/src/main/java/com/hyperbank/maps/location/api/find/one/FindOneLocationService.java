package com.hyperbank.maps.location.api.find.one;

import com.hyperbank.maps.location.entity.Location;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;

public interface FindOneLocationService extends ServiceInputOutputAware<Long, Location> {

	/**
	 * Find location by ID
	 */
	@Override
	Location execute(Long id) throws FunctionalException;
	
}
