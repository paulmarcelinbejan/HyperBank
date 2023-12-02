package com.hyperbank.staff.employee.api.update.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeUpdateRequest;
import com.paulmarcelinbejan.architecture.coordinator.CoordinatorRequestResponseAware;

public interface UpdateManyEmployeeCoordinator extends CoordinatorRequestResponseAware<List<EmployeeUpdateRequest>, List<EmployeeResponse>> {
	
}
