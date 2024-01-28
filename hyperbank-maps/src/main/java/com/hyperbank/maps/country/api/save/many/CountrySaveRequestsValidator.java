package com.hyperbank.maps.country.api.save.many;

import java.util.List;

import com.hyperbank.maps.country.dto.CountrySaveRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.validator.jakarta.JakartaCollectionValidator;

public interface CountrySaveRequestsValidator extends JakartaCollectionValidator<CountrySaveRequest, List<CountrySaveRequest>> {
	
}
