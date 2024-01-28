package com.hyperbank.maps.continent.api.find.many;

import java.util.List;

import com.hyperbank.maps.continent.entity.Continent;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindManyContinentService extends ServiceInputOutputAware<List<Integer>, List<Continent>> {

	/**
	 * Find many continent by IDs
	 */
	@Override
	List<Continent> execute(List<Integer> ids) throws FunctionalException, TechnicalException;
	
}
