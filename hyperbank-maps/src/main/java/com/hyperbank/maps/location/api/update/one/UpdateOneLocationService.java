package com.hyperbank.maps.location.api.update.one;

import com.hyperbank.maps.location.entity.Location;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface UpdateOneLocationService extends ServiceInputOutputAware<Location, Location> {

	/**
	 * Update location
	 */
	@Override
	Location execute(Location location) throws FunctionalException, TechnicalException;
	
}
