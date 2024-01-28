package com.hyperbank.maps.location.api.save.many;

import java.util.List;

import com.hyperbank.maps.location.entity.Location;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface SaveManyLocationService extends ServiceInputOutputAware<List<Location>, List<Location>> {

	/**
	 * Save many location
	 */
	@Override
	List<Location> execute(List<Location> location) throws FunctionalException, TechnicalException;
	
}
