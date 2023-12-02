package com.hyperbank.staff.employee.api.update.one;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeUpdateRequest;
import com.hyperbank.staff.employee.entity.Employee;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorFull;

@Coordinator
public class UpdateOneEmployeeCoordinatorImpl extends CoordinatorFull<EmployeeUpdateRequest, Employee, Employee, EmployeeResponse> implements UpdateOneEmployeeCoordinator {

	public UpdateOneEmployeeCoordinatorImpl(
			UpdateOneRequestEmployeeValidator validator,
			UpdateOneEmployeeMapper mapper, 
			UpdateOneEmployeeService service) {
		super(validator, mapper, service, mapper);
	}
	
}
