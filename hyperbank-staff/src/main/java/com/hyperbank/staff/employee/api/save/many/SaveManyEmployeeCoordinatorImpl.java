package com.hyperbank.staff.employee.api.save.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.hyperbank.staff.employee.entity.Employee;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorFull;

@Coordinator
public class SaveManyEmployeeCoordinatorImpl extends CoordinatorFull<List<EmployeeSaveRequest>, List<Employee>, List<Employee>, List<EmployeeResponse>> implements SaveManyEmployeeCoordinator {

	public SaveManyEmployeeCoordinatorImpl(
			SaveManyRequestEmployeeValidator validator,
			SaveManyEmployeeMapper mapper, 
			SaveManyEmployeeService service) {
		super(validator, mapper, service, mapper);
	}
	
}
