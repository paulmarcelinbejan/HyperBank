package com.hyperbank.staff.employee.api.find.one;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.entity.Employee;
import com.hyperbank.staff.employee.mapper.EntityToDtoEmployeeMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutInputMapping;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base.LongIdValidator;

@Coordinator
public class FindOneEmployeeCoordinatorImpl extends CoordinatorWithoutInputMapping<Long, Employee, EmployeeResponse> implements FindOneEmployeeCoordinator {

	public FindOneEmployeeCoordinatorImpl(
			LongIdValidator validator,
			EntityToDtoEmployeeMapper mapper, 
			FindOneEmployeeService service) {
		super(validator, service, mapper);
	}
	
}
