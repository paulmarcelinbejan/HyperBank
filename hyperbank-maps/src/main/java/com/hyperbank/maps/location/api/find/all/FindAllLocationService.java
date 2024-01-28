package com.hyperbank.maps.location.api.find.all;

import java.util.List;

import com.hyperbank.maps.location.entity.Location;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindAllLocationService extends ServiceOutputAware<List<Location>> {

	/**
	 * Find all location
	 */
	@Override
	List<Location> execute() throws FunctionalException, TechnicalException;
	
}
