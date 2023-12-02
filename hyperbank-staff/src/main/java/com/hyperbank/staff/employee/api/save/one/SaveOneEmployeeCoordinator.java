package com.hyperbank.staff.employee.api.save.one;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;

public interface SaveOneEmployeeCoordinator extends CoordinatorRequestResponseAware<EmployeeSaveRequest, EmployeeResponse> {
	
}
