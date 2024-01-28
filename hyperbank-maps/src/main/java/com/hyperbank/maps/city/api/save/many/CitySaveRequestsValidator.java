package com.hyperbank.maps.city.api.save.many;

import java.util.List;

import com.hyperbank.maps.city.dto.CitySaveRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.validator.jakarta.JakartaCollectionValidator;

public interface CitySaveRequestsValidator extends JakartaCollectionValidator<CitySaveRequest, List<CitySaveRequest>> {
	
}
