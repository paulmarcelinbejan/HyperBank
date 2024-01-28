package com.hyperbank.maps.country.api.delete.one;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutMappings;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base.IntegerIdValidator;

@Coordinator
public class DeleteOneCountryCoordinatorImpl extends CoordinatorWithoutMappings<Integer> implements DeleteOneCountryCoordinator {

	public DeleteOneCountryCoordinatorImpl(
			IntegerIdValidator validator,
			DeleteOneCountryService service) {
		super(validator, service);
	}
	
}
