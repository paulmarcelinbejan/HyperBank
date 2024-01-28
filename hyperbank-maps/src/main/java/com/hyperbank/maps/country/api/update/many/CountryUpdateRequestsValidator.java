package com.hyperbank.maps.country.api.update.many;

import java.util.List;

import com.hyperbank.maps.country.dto.CountryUpdateRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.validator.jakarta.JakartaCollectionValidator;

public interface CountryUpdateRequestsValidator extends JakartaCollectionValidator<CountryUpdateRequest, List<CountryUpdateRequest>> {
	
}
