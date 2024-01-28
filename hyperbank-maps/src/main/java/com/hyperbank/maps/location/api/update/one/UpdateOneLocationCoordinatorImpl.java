package com.hyperbank.maps.location.api.update.one;

import com.hyperbank.maps.location.dto.LocationResponse;
import com.hyperbank.maps.location.dto.LocationUpdateRequest;
import com.hyperbank.maps.location.entity.Location;
import com.hyperbank.maps.location.mapper.EntityToDtoLocationMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorFull;

@Coordinator
public class UpdateOneLocationCoordinatorImpl extends CoordinatorFull<LocationUpdateRequest, Location, Location, LocationResponse> implements UpdateOneLocationCoordinator {

	public UpdateOneLocationCoordinatorImpl(
			LocationUpdateRequestValidator validator,
			UpdateOneLocationMapper mapperInput, 
			UpdateOneLocationService service,
			EntityToDtoLocationMapper mapperOutput) {
		super(validator, mapperInput, service, mapperOutput);
	}
	
}
