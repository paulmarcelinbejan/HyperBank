package com.hyperbank.maps.location.api.save.one;

import com.hyperbank.maps.location.dto.LocationResponse;
import com.hyperbank.maps.location.dto.LocationSaveRequest;
import com.hyperbank.maps.location.entity.Location;
import com.hyperbank.maps.location.mapper.EntityToDtoLocationMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorFull;

@Coordinator
public class SaveOneLocationCoordinatorImpl extends CoordinatorFull<LocationSaveRequest, Location, Location, LocationResponse> implements SaveOneLocationCoordinator {

	public SaveOneLocationCoordinatorImpl(
			LocationSaveRequestValidator validator,
			SaveOneLocationMapper mapperInput, 
			SaveOneLocationService service,
			EntityToDtoLocationMapper mapperOutput) {
		super(validator, mapperInput, service, mapperOutput);
	}
	
}
