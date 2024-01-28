package com.hyperbank.maps.city.api.find.one;

import com.hyperbank.maps.city.entity.City;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;

public interface FindOneCityService extends ServiceInputOutputAware<Integer, City> {

	/**
	 * Find city by ID
	 */
	@Override
	City execute(Integer id) throws FunctionalException;
	
}
