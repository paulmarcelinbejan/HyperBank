package com.hyperbank.maps.continent.api.update.one;

import com.hyperbank.maps.continent.entity.Continent;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface UpdateOneContinentService extends ServiceInputOutputAware<Continent, Continent> {

	/**
	 * Update continent
	 */
	@Override
	Continent execute(Continent continent) throws FunctionalException, TechnicalException;
	
}
