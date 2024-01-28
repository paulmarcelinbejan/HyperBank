package com.hyperbank.maps.location.api.find.many;

import java.util.List;

import com.hyperbank.maps.location.dto.LocationResponse;
import com.hyperbank.maps.location.entity.Location;
import com.hyperbank.maps.location.mapper.EntitiesToDtosLocationMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutInputMapping;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base.LongIdsValidator;

@Coordinator
public class FindManyLocationCoordinatorImpl extends CoordinatorWithoutInputMapping<List<Long>, List<Location>, List<LocationResponse>> implements FindManyLocationCoordinator {

	public FindManyLocationCoordinatorImpl(
			LongIdsValidator validator,
			FindManyLocationService service,
			EntitiesToDtosLocationMapper mapper) {
		super(validator, service, mapper);
	}
	
}
