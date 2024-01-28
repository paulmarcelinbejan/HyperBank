package com.hyperbank.maps.location.api.delete.one;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutMappings;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base.LongIdValidator;

@Coordinator
public class DeleteOneLocationCoordinatorImpl extends CoordinatorWithoutMappings<Long> implements DeleteOneLocationCoordinator {

	public DeleteOneLocationCoordinatorImpl(
			LongIdValidator validator,
			DeleteOneLocationService service) {
		super(validator, service);
	}
	
}
