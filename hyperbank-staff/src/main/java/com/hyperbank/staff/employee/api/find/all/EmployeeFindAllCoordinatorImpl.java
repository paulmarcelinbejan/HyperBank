package com.hyperbank.staff.employee.api.find.all;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.coordinator.base.CoordinatorServiceResponse;
import com.paulmarcelinbejan.architecture.coordinator.stereotype.Coordinator;

@Coordinator
public class EmployeeFindAllCoordinatorImpl extends CoordinatorServiceResponse<List<Employee>, List<EmployeeResponse>> implements EmployeeFindAllCoordinator {

	public EmployeeFindAllCoordinatorImpl(
			EmployeeFindAllService service,
			EmployeeFindAllMapper mapper) {
		super(service, mapper);
	}
	
}
