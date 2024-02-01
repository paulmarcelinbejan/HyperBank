package com.hyperbank.maps.city.api.find.paged;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import io.github.paulmarcelinbejan.toolbox.web.request.PagedRequest;
import io.github.paulmarcelinbejan.toolbox.web.response.PagedResponse;

public interface FindPagedCityCoordinator extends CoordinatorRequestResponseAware<PagedRequest, PagedResponse> {
	
	/**
	 * Find filtered and paged cities
	 */
	@Override
	PagedResponse process(PagedRequest request) throws FunctionalException, TechnicalException;
	
}