package com.hyperbank.maps.country.api.update.many;

import java.util.List;

import com.hyperbank.maps.country.entity.Country;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface UpdateManyCountryService extends ServiceInputOutputAware<List<Country>, List<Country>> {

	/**
	 * Update many country
	 */
	@Override
	List<Country> execute(List<Country> country) throws FunctionalException, TechnicalException;
	
}
