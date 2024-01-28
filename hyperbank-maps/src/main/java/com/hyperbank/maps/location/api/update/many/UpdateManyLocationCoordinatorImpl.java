package com.hyperbank.maps.location.api.update.many;

import java.util.List;

import com.hyperbank.maps.location.dto.LocationResponse;
import com.hyperbank.maps.location.dto.LocationUpdateRequest;
import com.hyperbank.maps.location.entity.Location;
import com.hyperbank.maps.location.mapper.EntitiesToDtosLocationMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorFull;

@Coordinator
public class UpdateManyLocationCoordinatorImpl extends CoordinatorFull<List<LocationUpdateRequest>, List<Location>, List<Location>, List<LocationResponse>> implements UpdateManyLocationCoordinator {

	public UpdateManyLocationCoordinatorImpl(
			LocationUpdateRequestsValidator validator,
			UpdateManyLocationMapper mapperInput, 
			UpdateManyLocationService service,
			EntitiesToDtosLocationMapper mapperOutput) {
		super(validator, mapperInput, service, mapperOutput);
	}
	
}
