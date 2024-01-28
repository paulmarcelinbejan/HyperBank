package com.hyperbank.maps.location.api.find.one;

import com.hyperbank.maps.location.dto.LocationResponse;
import com.hyperbank.maps.location.entity.Location;
import com.hyperbank.maps.location.mapper.EntityToDtoLocationMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutInputMapping;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base.LongIdValidator;

@Coordinator
public class FindOneLocationCoordinatorImpl extends CoordinatorWithoutInputMapping<Long, Location, LocationResponse> implements FindOneLocationCoordinator {

	public FindOneLocationCoordinatorImpl(
			LongIdValidator validator,
			EntityToDtoLocationMapper mapper, 
			FindOneLocationService service) {
		super(validator, service, mapper);
	}
	
}
