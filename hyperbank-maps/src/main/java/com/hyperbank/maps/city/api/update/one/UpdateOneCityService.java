package com.hyperbank.maps.city.api.update.one;

import com.hyperbank.maps.city.entity.City;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface UpdateOneCityService extends ServiceInputOutputAware<City, City> {

	/**
	 * Update city
	 */
	@Override
	City execute(City city) throws FunctionalException, TechnicalException;
	
}
