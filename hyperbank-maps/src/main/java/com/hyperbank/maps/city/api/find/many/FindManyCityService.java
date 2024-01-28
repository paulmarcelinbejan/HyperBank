package com.hyperbank.maps.city.api.find.many;

import java.util.List;

import com.hyperbank.maps.city.entity.City;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindManyCityService extends ServiceInputOutputAware<List<Integer>, List<City>> {

	/**
	 * Find many city by IDs
	 */
	@Override
	List<City> execute(List<Integer> ids) throws FunctionalException, TechnicalException;
	
}
