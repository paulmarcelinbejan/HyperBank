package com.hyperbank.staff.employee.api.save.one;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.paulmarcelinbejan.architecture.coordinator.CoordinatorRequestResponseAware;

public interface EmployeeSaveOneCoordinator extends CoordinatorRequestResponseAware<EmployeeSaveRequest, EmployeeResponse> {
	
}
