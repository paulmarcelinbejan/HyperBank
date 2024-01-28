package com.hyperbank.maps.continent.api.delete.many;

import java.util.List;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutMappings;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base.IntegerIdsValidator;

@Coordinator
public class DeleteManyContinentCoordinatorImpl extends CoordinatorWithoutMappings<List<Integer>> implements DeleteManyContinentCoordinator {

	public DeleteManyContinentCoordinatorImpl(
			IntegerIdsValidator validator,
			DeleteManyContinentService service) {
		super(validator, service);
	}
	
}
