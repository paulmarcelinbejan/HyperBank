package com.hyperbank.staff.employee.api.delete.one;

import com.hyperbank.architecture.web.validator.id.base.LongIdValidator;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutMappings;

@Coordinator
public class DeleteOneEmployeeCoordinatorImpl extends CoordinatorWithoutMappings<Long> implements DeleteOneEmployeeCoordinator {

	public DeleteOneEmployeeCoordinatorImpl(
			LongIdValidator validator,
			DeleteOneEmployeeService service) {
		super(validator, service);
	}
	
}
