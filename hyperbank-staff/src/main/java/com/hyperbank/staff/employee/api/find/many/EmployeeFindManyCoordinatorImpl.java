package com.hyperbank.staff.employee.api.find.many;

import java.util.List;

import com.hyperbank.architecture.web.validator.id.base.LongIdsValidator;
import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.coordinator.base.CoordinatorWithoutInputMapping;
import com.paulmarcelinbejan.architecture.coordinator.stereotype.Coordinator;

@Coordinator
public class EmployeeFindManyCoordinatorImpl extends CoordinatorWithoutInputMapping<List<Long>, List<Employee>, List<EmployeeResponse>> implements EmployeeFindManyCoordinator {

	public EmployeeFindManyCoordinatorImpl(
			LongIdsValidator validator,
			EmployeeFindManyService service,
			EmployeeFindManyMapper mapper) {
		super(validator, service, mapper);
	}
	
}
