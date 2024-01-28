package com.hyperbank.maps.continent.api.update.many;

import java.util.List;

import com.hyperbank.maps.continent.dto.ContinentUpdateRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.validator.jakarta.JakartaCollectionValidator;

public interface ContinentUpdateRequestsValidator extends JakartaCollectionValidator<ContinentUpdateRequest, List<ContinentUpdateRequest>> {
	
}
