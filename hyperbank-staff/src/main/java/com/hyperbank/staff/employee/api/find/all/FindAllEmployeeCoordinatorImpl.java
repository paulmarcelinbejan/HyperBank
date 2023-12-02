package com.hyperbank.staff.employee.api.find.all;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.entity.Employee;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorServiceResponse;

@Coordinator
public class FindAllEmployeeCoordinatorImpl extends CoordinatorServiceResponse<List<Employee>, List<EmployeeResponse>> implements FindAllEmployeeCoordinator {

	public FindAllEmployeeCoordinatorImpl(
			FindAllEmployeeService service,
			FindAllEmployeeMapper mapper) {
		super(service, mapper);
	}
	
}
