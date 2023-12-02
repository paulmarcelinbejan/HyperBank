package com.hyperbank.staff.employee.api.delete.many;

import java.util.List;

import com.hyperbank.architecture.web.validator.id.base.LongIdsValidator;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutMappings;

@Coordinator
public class DeleteManyEmployeeCoordinatorImpl extends CoordinatorWithoutMappings<List<Long>> implements DeleteManyEmployeeCoordinator {

	public DeleteManyEmployeeCoordinatorImpl(
			LongIdsValidator validator,
			DeleteManyEmployeeService service) {
		super(validator, service);
	}
	
}
