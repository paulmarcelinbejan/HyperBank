package com.hyperbank.staff.employee.api.save.one;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.coordinator.base.CoordinatorFull;
import com.paulmarcelinbejan.architecture.coordinator.stereotype.Coordinator;

@Coordinator
public class EmployeeSaveOneCoordinatorImpl extends CoordinatorFull<EmployeeSaveRequest, Employee, Employee, EmployeeResponse> implements EmployeeSaveOneCoordinator {

	public EmployeeSaveOneCoordinatorImpl(
			EmployeeSaveOneRequestValidator validator,
			EmployeeSaveOneMapper mapper, 
			EmployeeSaveOneService service) {
		super(validator, mapper, service, mapper);
	}
	
}
