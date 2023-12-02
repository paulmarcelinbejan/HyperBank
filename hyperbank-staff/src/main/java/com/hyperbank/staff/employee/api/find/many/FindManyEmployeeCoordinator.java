package com.hyperbank.staff.employee.api.find.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;

public interface FindManyEmployeeCoordinator extends CoordinatorRequestResponseAware<List<Long>, List<EmployeeResponse>> {
	
}
