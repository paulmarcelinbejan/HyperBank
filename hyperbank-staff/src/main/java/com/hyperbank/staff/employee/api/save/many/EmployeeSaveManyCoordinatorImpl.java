package com.hyperbank.staff.employee.api.save.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.coordinator.base.CoordinatorFull;
import com.paulmarcelinbejan.architecture.coordinator.stereotype.Coordinator;

@Coordinator
public class EmployeeSaveManyCoordinatorImpl extends CoordinatorFull<List<EmployeeSaveRequest>, List<Employee>, List<Employee>, List<EmployeeResponse>> implements EmployeeSaveManyCoordinator {

	public EmployeeSaveManyCoordinatorImpl(
			EmployeeSaveManyRequestValidator validator,
			EmployeeSaveManyMapper mapper, 
			EmployeeSaveManyService service) {
		super(validator, mapper, service, mapper);
	}
	
}
