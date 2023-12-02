package com.hyperbank.staff.employee.api.save.one;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.coordinator.base.CoordinatorFull;
import com.paulmarcelinbejan.architecture.coordinator.stereotype.Coordinator;

@Coordinator
public class SaveOneEmployeeCoordinatorImpl extends CoordinatorFull<EmployeeSaveRequest, Employee, Employee, EmployeeResponse> implements SaveOneEmployeeCoordinator {

	public SaveOneEmployeeCoordinatorImpl(
			SaveOneRequestEmployeeValidator validator,
			SaveOneEmployeeMapper mapper, 
			SaveOneEmployeeService service) {
		super(validator, mapper, service, mapper);
	}
	
}
