package com.hyperbank.staff.employee.api.save.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.paulmarcelinbejan.architecture.coordinator.CoordinatorRequestResponseAware;

public interface SaveManyEmployeeCoordinator extends CoordinatorRequestResponseAware<List<EmployeeSaveRequest>, List<EmployeeResponse>> {
	
}
