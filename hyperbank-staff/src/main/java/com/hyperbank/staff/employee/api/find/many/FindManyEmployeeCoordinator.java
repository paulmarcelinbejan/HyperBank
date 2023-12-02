package com.hyperbank.staff.employee.api.find.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.paulmarcelinbejan.architecture.coordinator.CoordinatorRequestResponseAware;

public interface FindManyEmployeeCoordinator extends CoordinatorRequestResponseAware<List<Long>, List<EmployeeResponse>> {
	
}
