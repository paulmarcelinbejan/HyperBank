package com.hyperbank.staff.employee.api.save.one;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.hyperbank.staff.employee.entity.Employee;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorFull;

@Coordinator
public class SaveOneEmployeeCoordinatorImpl extends CoordinatorFull<EmployeeSaveRequest, Employee, Employee, EmployeeResponse> implements SaveOneEmployeeCoordinator {

	public SaveOneEmployeeCoordinatorImpl(
			SaveOneRequestEmployeeValidator validator,
			SaveOneEmployeeMapper mapper, 
			SaveOneEmployeeService service) {
		super(validator, mapper, service, mapper);
	}
	
}
