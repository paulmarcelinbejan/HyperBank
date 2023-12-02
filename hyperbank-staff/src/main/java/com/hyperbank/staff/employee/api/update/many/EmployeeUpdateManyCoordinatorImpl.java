package com.hyperbank.staff.employee.api.update.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeUpdateRequest;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.coordinator.base.CoordinatorFull;
import com.paulmarcelinbejan.architecture.coordinator.stereotype.Coordinator;

@Coordinator
public class EmployeeUpdateManyCoordinatorImpl extends CoordinatorFull<List<EmployeeUpdateRequest>, List<Employee>, List<Employee>, List<EmployeeResponse>> implements EmployeeUpdateManyCoordinator {

	public EmployeeUpdateManyCoordinatorImpl(
			EmployeeUpdateManyRequestValidator validator,
			EmployeeUpdateManyMapper mapper, 
			EmployeeUpdateManyService service) {
		super(validator, mapper, service, mapper);
	}
	
}
