package com.hyperbank.staff.employee.api.update.one;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeUpdateRequest;
import com.hyperbank.staff.employee.entity.Employee;
import com.hyperbank.staff.employee.mapper.EntityToDtoEmployeeMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorFull;

@Coordinator
public class UpdateOneEmployeeCoordinatorImpl extends CoordinatorFull<EmployeeUpdateRequest, Employee, Employee, EmployeeResponse> implements UpdateOneEmployeeCoordinator {

	public UpdateOneEmployeeCoordinatorImpl(
			EmployeeUpdateRequestValidator validator,
			UpdateOneEmployeeMapper mapperInput, 
			UpdateOneEmployeeService service,
			EntityToDtoEmployeeMapper mapperOutput) {
		super(validator, mapperInput, service, mapperOutput);
	}
	
}
