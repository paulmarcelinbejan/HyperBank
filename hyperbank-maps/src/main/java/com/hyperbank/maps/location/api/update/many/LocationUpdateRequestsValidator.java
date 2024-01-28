package com.hyperbank.maps.location.api.update.many;

import java.util.List;

import com.hyperbank.maps.location.dto.LocationUpdateRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.validator.jakarta.JakartaCollectionValidator;

public interface LocationUpdateRequestsValidator extends JakartaCollectionValidator<LocationUpdateRequest, List<LocationUpdateRequest>> {
	
}
