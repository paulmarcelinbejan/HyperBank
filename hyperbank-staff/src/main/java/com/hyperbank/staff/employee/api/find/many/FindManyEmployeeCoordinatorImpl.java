package com.hyperbank.staff.employee.api.find.many;

import java.util.List;

import com.hyperbank.architecture.web.validator.id.base.LongIdsValidator;
import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.entity.Employee;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutInputMapping;

@Coordinator
public class FindManyEmployeeCoordinatorImpl extends CoordinatorWithoutInputMapping<List<Long>, List<Employee>, List<EmployeeResponse>> implements FindManyEmployeeCoordinator {

	public FindManyEmployeeCoordinatorImpl(
			LongIdsValidator validator,
			FindManyEmployeeService service,
			FindManyEmployeeMapper mapper) {
		super(validator, service, mapper);
	}
	
}
