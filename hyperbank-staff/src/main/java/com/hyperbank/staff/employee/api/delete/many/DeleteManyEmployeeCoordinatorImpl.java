package com.hyperbank.staff.employee.api.delete.many;

import java.util.List;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutMappings;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base.LongIdsValidator;

@Coordinator
public class DeleteManyEmployeeCoordinatorImpl extends CoordinatorWithoutMappings<List<Long>> implements DeleteManyEmployeeCoordinator {

	public DeleteManyEmployeeCoordinatorImpl(
			LongIdsValidator validator,
			DeleteManyEmployeeService service) {
		super(validator, service);
	}
	
}
