package com.hyperbank.maps.city.api.find.paged;

import org.springframework.data.domain.Page;

import com.hyperbank.maps.city.entity.City;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import io.github.paulmarcelinbejan.toolbox.web.request.PagedRequest;

public interface FindPagedCityService extends ServiceInputOutputAware<PagedRequest, Page<City>> {

	/**
	 * Find filtered and paged cities
	 */
	@Override
	Page<City> execute(PagedRequest request) throws FunctionalException, TechnicalException;
	
}
