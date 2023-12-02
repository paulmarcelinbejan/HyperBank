package com.hyperbank.staff.employee.api.delete.many;

import java.util.List;

import com.hyperbank.architecture.web.validator.id.base.LongIdsValidator;
import com.paulmarcelinbejan.architecture.coordinator.base.CoordinatorWithoutMappings;
import com.paulmarcelinbejan.architecture.coordinator.stereotype.Coordinator;

@Coordinator
public class DeleteManyEmployeeCoordinatorImpl extends CoordinatorWithoutMappings<List<Long>> implements DeleteManyEmployeeCoordinator {

	public DeleteManyEmployeeCoordinatorImpl(
			LongIdsValidator validator,
			DeleteManyEmployeeService service) {
		super(validator, service);
	}
	
}
