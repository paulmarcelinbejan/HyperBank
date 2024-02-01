package com.hyperbank.maps.city.api.find.paged;

import org.springframework.data.domain.Page;

import com.hyperbank.maps.city.entity.City;
import com.hyperbank.maps.city.mapper.PagedEntitiesToPagedResponseCityMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutInputMapping;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.jakarta.JakartaBaseValidator;
import io.github.paulmarcelinbejan.toolbox.web.request.PagedRequest;
import io.github.paulmarcelinbejan.toolbox.web.response.PagedResponse;

@Coordinator
public class FindPagedCityCoordinatorImpl
		extends CoordinatorWithoutInputMapping<PagedRequest, Page<City>, PagedResponse>
		implements FindPagedCityCoordinator {

	public FindPagedCityCoordinatorImpl(
			JakartaBaseValidator<PagedRequest> validator,
			PagedEntitiesToPagedResponseCityMapper mapper, 
			FindPagedCityService service) {
		super(validator, service, mapper);
	}
	
}
