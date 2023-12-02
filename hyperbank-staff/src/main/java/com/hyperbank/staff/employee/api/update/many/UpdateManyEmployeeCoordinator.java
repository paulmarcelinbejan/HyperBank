package com.hyperbank.staff.employee.api.update.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeUpdateRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;

public interface UpdateManyEmployeeCoordinator extends CoordinatorRequestResponseAware<List<EmployeeUpdateRequest>, List<EmployeeResponse>> {
	
}
