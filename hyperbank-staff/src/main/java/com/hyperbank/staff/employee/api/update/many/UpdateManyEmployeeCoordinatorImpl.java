package com.hyperbank.staff.employee.api.update.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeUpdateRequest;
import com.hyperbank.staff.employee.entity.Employee;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorFull;

@Coordinator
public class UpdateManyEmployeeCoordinatorImpl extends CoordinatorFull<List<EmployeeUpdateRequest>, List<Employee>, List<Employee>, List<EmployeeResponse>> implements UpdateManyEmployeeCoordinator {

	public UpdateManyEmployeeCoordinatorImpl(
			UpdateManyRequestEmployeeValidator validator,
			UpdateManyEmployeeMapper mapper, 
			UpdateManyEmployeeService service) {
		super(validator, mapper, service, mapper);
	}
	
}
