package com.hyperbank.staff.employee.api.find.one;

import com.hyperbank.staff.employee.dto.EmployeeResponse;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;

public interface FindOneEmployeeCoordinator extends CoordinatorRequestResponseAware<Long, EmployeeResponse> {
	
}
