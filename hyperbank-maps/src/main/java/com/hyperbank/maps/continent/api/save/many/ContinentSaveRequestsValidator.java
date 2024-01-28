package com.hyperbank.maps.continent.api.save.many;

import java.util.List;

import com.hyperbank.maps.continent.dto.ContinentSaveRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.validator.jakarta.JakartaCollectionValidator;

public interface ContinentSaveRequestsValidator extends JakartaCollectionValidator<ContinentSaveRequest, List<ContinentSaveRequest>> {
	
}
