package com.hyperbank.maps.location.api.save.many;

import java.util.List;

import com.hyperbank.maps.location.dto.LocationSaveRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.validator.jakarta.JakartaCollectionValidator;

public interface LocationSaveRequestsValidator extends JakartaCollectionValidator<LocationSaveRequest, List<LocationSaveRequest>> {
	
}
