package com.hyperbank.staff.employee.api.find.all;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.coordinator.base.CoordinatorServiceResponse;
import com.paulmarcelinbejan.architecture.coordinator.stereotype.Coordinator;

@Coordinator
public class FindAllEmployeeCoordinatorImpl extends CoordinatorServiceResponse<List<Employee>, List<EmployeeResponse>> implements FindAllEmployeeCoordinator {

	public FindAllEmployeeCoordinatorImpl(
			FindAllEmployeeService service,
			FindAllEmployeeMapper mapper) {
		super(service, mapper);
	}
	
}
