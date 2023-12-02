package com.hyperbank.staff.employee.api.update.one;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeUpdateRequest;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.coordinator.base.CoordinatorFull;
import com.paulmarcelinbejan.architecture.coordinator.stereotype.Coordinator;

@Coordinator
public class EmployeeUpdateOneCoordinatorImpl extends CoordinatorFull<EmployeeUpdateRequest, Employee, Employee, EmployeeResponse> implements EmployeeUpdateOneCoordinator {

	public EmployeeUpdateOneCoordinatorImpl(
			EmployeeUpdateOneRequestValidator validator,
			EmployeeUpdateOneMapper mapper, 
			EmployeeUpdateOneService service) {
		super(validator, mapper, service, mapper);
	}
	
}
