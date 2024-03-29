package com.hyperbank.staff.employee.api.find.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.entity.Employee;
import com.hyperbank.staff.employee.mapper.EntitiesToDtosEmployeeMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutInputMapping;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base.LongIdsValidator;

@Coordinator
public class FindManyEmployeeCoordinatorImpl extends CoordinatorWithoutInputMapping<List<Long>, List<Employee>, List<EmployeeResponse>> implements FindManyEmployeeCoordinator {

	public FindManyEmployeeCoordinatorImpl(
			LongIdsValidator validator,
			FindManyEmployeeService service,
			EntitiesToDtosEmployeeMapper mapper) {
		super(validator, service, mapper);
	}
	
}
