package com.hyperbank.maps.city.api.find.all;

import java.util.List;

import com.hyperbank.maps.city.entity.City;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindAllCityService extends ServiceOutputAware<List<City>> {

	/**
	 * Find all city
	 */
	@Override
	List<City> execute() throws FunctionalException, TechnicalException;
	
}
