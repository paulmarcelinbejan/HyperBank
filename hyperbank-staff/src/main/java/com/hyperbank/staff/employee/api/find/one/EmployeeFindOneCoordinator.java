package com.hyperbank.staff.employee.api.find.one;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.paulmarcelinbejan.architecture.coordinator.CoordinatorRequestResponseAware;

public interface EmployeeFindOneCoordinator extends CoordinatorRequestResponseAware<Long, EmployeeResponse> {
	
}
