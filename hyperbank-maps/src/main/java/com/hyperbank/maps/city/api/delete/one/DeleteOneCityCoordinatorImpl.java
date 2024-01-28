package com.hyperbank.maps.city.api.delete.one;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutMappings;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base.IntegerIdValidator;

@Coordinator
public class DeleteOneCityCoordinatorImpl extends CoordinatorWithoutMappings<Integer> implements DeleteOneCityCoordinator {

	public DeleteOneCityCoordinatorImpl(
			IntegerIdValidator validator,
			DeleteOneCityService service) {
		super(validator, service);
	}
	
}
