package com.hyperbank.maps.country.api.delete.many;

import java.util.List;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutMappings;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base.IntegerIdsValidator;

@Coordinator
public class DeleteManyCountryCoordinatorImpl extends CoordinatorWithoutMappings<List<Integer>> implements DeleteManyCountryCoordinator {

	public DeleteManyCountryCoordinatorImpl(
			IntegerIdsValidator validator,
			DeleteManyCountryService service) {
		super(validator, service);
	}
	
}
