package com.hyperbank.staff.employee.api.find.all;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.paulmarcelinbejan.architecture.coordinator.CoordinatorResponseAware;

public interface EmployeeFindAllCoordinator extends CoordinatorResponseAware<List<EmployeeResponse>> {
	
}
