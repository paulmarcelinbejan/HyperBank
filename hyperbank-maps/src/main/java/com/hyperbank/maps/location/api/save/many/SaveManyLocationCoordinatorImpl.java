package com.hyperbank.maps.location.api.save.many;

import java.util.List;

import com.hyperbank.maps.location.dto.LocationResponse;
import com.hyperbank.maps.location.dto.LocationSaveRequest;
import com.hyperbank.maps.location.entity.Location;
import com.hyperbank.maps.location.mapper.EntitiesToDtosLocationMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorFull;

@Coordinator
public class SaveManyLocationCoordinatorImpl extends CoordinatorFull<List<LocationSaveRequest>, List<Location>, List<Location>, List<LocationResponse>> implements SaveManyLocationCoordinator {

	public SaveManyLocationCoordinatorImpl(
			LocationSaveRequestsValidator validator,
			SaveManyLocationMapper mapperInput, 
			SaveManyLocationService service,
			EntitiesToDtosLocationMapper mapperOutput) {
		super(validator, mapperInput, service, mapperOutput);
	}
	
}
