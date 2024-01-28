package com.hyperbank.maps.continent.api.find.all;

import java.util.List;

import com.hyperbank.maps.continent.entity.Continent;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindAllContinentService extends ServiceOutputAware<List<Continent>> {

	/**
	 * Find all continent
	 */
	@Override
	List<Continent> execute() throws FunctionalException, TechnicalException;
	
}
