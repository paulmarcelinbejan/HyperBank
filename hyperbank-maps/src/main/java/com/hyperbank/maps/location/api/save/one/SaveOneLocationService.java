package com.hyperbank.maps.location.api.save.one;

import com.hyperbank.maps.location.entity.Location;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface SaveOneLocationService extends ServiceInputOutputAware<Location, Location> {

	/**
	 * Save location
	 */
	@Override
	Location execute(Location location) throws FunctionalException, TechnicalException;
	
}
