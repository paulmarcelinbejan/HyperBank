package com.hyperbank.staff.employee.api.update.one;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeUpdateRequest;
import com.paulmarcelinbejan.architecture.coordinator.CoordinatorRequestResponseAware;

public interface UpdateOneEmployeeCoordinator extends CoordinatorRequestResponseAware<EmployeeUpdateRequest, EmployeeResponse> {
	
}
