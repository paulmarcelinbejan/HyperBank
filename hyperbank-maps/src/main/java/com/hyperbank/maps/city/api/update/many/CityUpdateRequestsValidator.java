package com.hyperbank.maps.city.api.update.many;

import java.util.List;

import com.hyperbank.maps.city.dto.CityUpdateRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.validator.jakarta.JakartaCollectionValidator;

public interface CityUpdateRequestsValidator extends JakartaCollectionValidator<CityUpdateRequest, List<CityUpdateRequest>> {
	
}
