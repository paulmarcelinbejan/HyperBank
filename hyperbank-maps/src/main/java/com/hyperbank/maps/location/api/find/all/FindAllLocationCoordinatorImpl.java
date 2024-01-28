package com.hyperbank.maps.location.api.find.all;

import java.util.List;

import com.hyperbank.maps.location.dto.LocationResponse;
import com.hyperbank.maps.location.entity.Location;
import com.hyperbank.maps.location.mapper.EntitiesToDtosLocationMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorServiceResponse;

@Coordinator
public class FindAllLocationCoordinatorImpl extends CoordinatorServiceResponse<List<Location>, List<LocationResponse>> implements FindAllLocationCoordinator {

	public FindAllLocationCoordinatorImpl(
			FindAllLocationService service,
			EntitiesToDtosLocationMapper mapper) {
		super(service, mapper);
	}
	
}
