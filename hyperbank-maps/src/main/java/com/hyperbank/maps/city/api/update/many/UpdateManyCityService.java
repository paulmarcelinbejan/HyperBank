package com.hyperbank.maps.city.api.update.many;

import java.util.List;

import com.hyperbank.maps.city.entity.City;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface UpdateManyCityService extends ServiceInputOutputAware<List<City>, List<City>> {

	/**
	 * Update many city
	 */
	@Override
	List<City> execute(List<City> city) throws FunctionalException, TechnicalException;
	
}
