package com.hyperbank.staff.employee.api.delete.one;

import com.hyperbank.architecture.web.validator.id.base.LongIdValidator;
import com.paulmarcelinbejan.architecture.coordinator.base.CoordinatorWithoutMappings;
import com.paulmarcelinbejan.architecture.coordinator.stereotype.Coordinator;

@Coordinator
public class DeleteOneEmployeeCoordinatorImpl extends CoordinatorWithoutMappings<Long> implements DeleteOneEmployeeCoordinator {

	public DeleteOneEmployeeCoordinatorImpl(
			LongIdValidator validator,
			DeleteOneEmployeeService service) {
		super(validator, service);
	}
	
}
