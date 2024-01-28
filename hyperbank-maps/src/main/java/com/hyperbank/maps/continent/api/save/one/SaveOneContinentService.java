package com.hyperbank.maps.continent.api.save.one;

import com.hyperbank.maps.continent.entity.Continent;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface SaveOneContinentService extends ServiceInputOutputAware<Continent, Continent> {

	/**
	 * Save continent
	 */
	@Override
	Continent execute(Continent continent) throws FunctionalException, TechnicalException;
	
}
