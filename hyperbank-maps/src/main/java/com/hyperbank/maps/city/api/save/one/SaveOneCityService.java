package com.hyperbank.maps.city.api.save.one;

import com.hyperbank.maps.city.entity.City;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface SaveOneCityService extends ServiceInputOutputAware<City, City> {

	/**
	 * Save city
	 */
	@Override
	City execute(City city) throws FunctionalException, TechnicalException;
	
}
