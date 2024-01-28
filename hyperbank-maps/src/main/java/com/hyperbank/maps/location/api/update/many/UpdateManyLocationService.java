package com.hyperbank.maps.location.api.update.many;

import java.util.List;

import com.hyperbank.maps.location.entity.Location;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface UpdateManyLocationService extends ServiceInputOutputAware<List<Location>, List<Location>> {

	/**
	 * Update many location
	 */
	@Override
	List<Location> execute(List<Location> location) throws FunctionalException, TechnicalException;
	
}
