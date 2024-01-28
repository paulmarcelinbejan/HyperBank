package com.hyperbank.maps.location.api.delete.many;

import java.util.List;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutMappings;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base.LongIdsValidator;

@Coordinator
public class DeleteManyLocationCoordinatorImpl extends CoordinatorWithoutMappings<List<Long>> implements DeleteManyLocationCoordinator {

	public DeleteManyLocationCoordinatorImpl(
			LongIdsValidator validator,
			DeleteManyLocationService service) {
		super(validator, service);
	}
	
}
