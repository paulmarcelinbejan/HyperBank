package com.hyperbank.staff.employee.api.delete.many;

import java.util.List;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestAware;

public interface DeleteManyEmployeeCoordinator extends CoordinatorRequestAware<List<Long>> {
	
}
