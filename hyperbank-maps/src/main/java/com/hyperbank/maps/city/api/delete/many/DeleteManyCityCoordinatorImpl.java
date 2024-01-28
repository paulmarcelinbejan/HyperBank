package com.hyperbank.maps.city.api.delete.many;

import java.util.List;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutMappings;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base.IntegerIdsValidator;

@Coordinator
public class DeleteManyCityCoordinatorImpl extends CoordinatorWithoutMappings<List<Integer>> implements DeleteManyCityCoordinator {

	public DeleteManyCityCoordinatorImpl(
			IntegerIdsValidator validator,
			DeleteManyCityService service) {
		super(validator, service);
	}
	
}
