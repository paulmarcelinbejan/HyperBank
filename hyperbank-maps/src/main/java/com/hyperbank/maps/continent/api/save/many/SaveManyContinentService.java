package com.hyperbank.maps.continent.api.save.many;

import java.util.List;

import com.hyperbank.maps.continent.entity.Continent;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface SaveManyContinentService extends ServiceInputOutputAware<List<Continent>, List<Continent>> {

	/**
	 * Save many continent
	 */
	@Override
	List<Continent> execute(List<Continent> continent) throws FunctionalException, TechnicalException;
	
}
