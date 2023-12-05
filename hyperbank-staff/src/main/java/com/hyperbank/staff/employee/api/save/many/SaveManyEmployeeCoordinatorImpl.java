package com.hyperbank.staff.employee.api.save.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.hyperbank.staff.employee.entity.Employee;
import com.hyperbank.staff.employee.mapper.EntitiesToDtosEmployeeMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorFull;

@Coordinator
public class SaveManyEmployeeCoordinatorImpl extends CoordinatorFull<List<EmployeeSaveRequest>, List<Employee>, List<Employee>, List<EmployeeResponse>> implements SaveManyEmployeeCoordinator {

	public SaveManyEmployeeCoordinatorImpl(
			EmployeeSaveRequestsValidator validator,
			SaveManyEmployeeMapper mapperInput, 
			SaveManyEmployeeService service,
			EntitiesToDtosEmployeeMapper mapperOutput) {
		super(validator, mapperInput, service, mapperOutput);
	}
	
}
