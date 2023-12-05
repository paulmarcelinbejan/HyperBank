package com.hyperbank.staff.employee.api.save.one;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.hyperbank.staff.employee.entity.Employee;
import com.hyperbank.staff.employee.mapper.EntityToDtoEmployeeMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorFull;

@Coordinator
public class SaveOneEmployeeCoordinatorImpl extends CoordinatorFull<EmployeeSaveRequest, Employee, Employee, EmployeeResponse> implements SaveOneEmployeeCoordinator {

	public SaveOneEmployeeCoordinatorImpl(
			EmployeeSaveRequestValidator validator,
			SaveOneEmployeeMapper mapperInput, 
			SaveOneEmployeeService service,
			EntityToDtoEmployeeMapper mapperOutput) {
		super(validator, mapperInput, service, mapperOutput);
	}
	
}
