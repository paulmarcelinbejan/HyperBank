package com.hyperbank.staff.employee.api.find.one;

import com.hyperbank.architecture.web.validator.id.base.LongIdValidator;
import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.entity.Employee;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutInputMapping;

@Coordinator
public class FindOneEmployeeCoordinatorImpl extends CoordinatorWithoutInputMapping<Long, Employee, EmployeeResponse> implements FindOneEmployeeCoordinator {

	public FindOneEmployeeCoordinatorImpl(
			LongIdValidator validator,
			FindOneEmployeeMapper mapper, 
			FindOneEmployeeService service) {
		super(validator, service, mapper);
	}
	
}
