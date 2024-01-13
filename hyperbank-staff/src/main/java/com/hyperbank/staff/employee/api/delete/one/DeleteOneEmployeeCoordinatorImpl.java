package com.hyperbank.staff.employee.api.delete.one;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutMappings;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base.LongIdValidator;

@Coordinator
public class DeleteOneEmployeeCoordinatorImpl extends CoordinatorWithoutMappings<Long> implements DeleteOneEmployeeCoordinator {

	public DeleteOneEmployeeCoordinatorImpl(
			LongIdValidator validator,
			DeleteOneEmployeeService service) {
		super(validator, service);
	}
	
}
