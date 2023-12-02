package com.hyperbank.staff.employee.api.find.one;

import com.hyperbank.architecture.web.validator.id.base.LongIdValidator;
import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.coordinator.base.CoordinatorWithoutInputMapping;
import com.paulmarcelinbejan.architecture.coordinator.stereotype.Coordinator;

@Coordinator
public class EmployeeFindOneCoordinatorImpl extends CoordinatorWithoutInputMapping<Long, Employee, EmployeeResponse> implements EmployeeFindOneCoordinator {

	public EmployeeFindOneCoordinatorImpl(
			LongIdValidator validator,
			EmployeeFindOneMapper mapper, 
			EmployeeFindOneService service) {
		super(validator, service, mapper);
	}
	
}
