package com.hyperbank.maps.location.api.find.many;

import java.util.List;

import com.hyperbank.maps.location.entity.Location;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindManyLocationService extends ServiceInputOutputAware<List<Long>, List<Location>> {

	/**
	 * Find many location by IDs
	 */
	@Override
	List<Location> execute(List<Long> ids) throws FunctionalException, TechnicalException;
	
}
