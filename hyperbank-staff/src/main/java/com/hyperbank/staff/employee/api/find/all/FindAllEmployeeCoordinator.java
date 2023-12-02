package com.hyperbank.staff.employee.api.find.all;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorResponseAware;

public interface FindAllEmployeeCoordinator extends CoordinatorResponseAware<List<EmployeeResponse>> {
	
}
