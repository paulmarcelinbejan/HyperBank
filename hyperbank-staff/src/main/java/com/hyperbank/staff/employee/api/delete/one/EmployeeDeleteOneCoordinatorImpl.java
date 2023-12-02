package com.hyperbank.staff.employee.api.delete.one;

import com.hyperbank.architecture.web.validator.id.base.LongIdValidator;
import com.paulmarcelinbejan.architecture.coordinator.base.CoordinatorWithoutMappings;
import com.paulmarcelinbejan.architecture.coordinator.stereotype.Coordinator;

@Coordinator
public class EmployeeDeleteOneCoordinatorImpl extends CoordinatorWithoutMappings<Long> implements EmployeeDeleteOneCoordinator {

	public EmployeeDeleteOneCoordinatorImpl(
			LongIdValidator validator,
			EmployeeDeleteOneService service) {
		super(validator, service);
	}
	
}
