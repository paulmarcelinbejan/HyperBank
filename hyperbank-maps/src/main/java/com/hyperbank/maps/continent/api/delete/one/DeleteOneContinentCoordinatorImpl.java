package com.hyperbank.maps.continent.api.delete.one;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutMappings;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base.IntegerIdValidator;

@Coordinator
public class DeleteOneContinentCoordinatorImpl extends CoordinatorWithoutMappings<Integer> implements DeleteOneContinentCoordinator {

	public DeleteOneContinentCoordinatorImpl(
			IntegerIdValidator validator,
			DeleteOneContinentService service) {
		super(validator, service);
	}
	
}
