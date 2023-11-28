package com.hyperbank.staff.employee.api.find.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.sniper.base.BaseSniper;
import com.paulmarcelinbejan.architecture.sniper.stereotype.Sniper;

@Sniper
public class EmployeeFindManySniper extends BaseSniper<List<Long>, List<Long>, List<Employee>, List<EmployeeResponse>> {

	public EmployeeFindManySniper(
			EmployeeFindManyRequestValidator validator,
			EmployeeFindManyMapper mapper, 
			EmployeeFindManyService service) {
		super(validator, mapper, service, mapper);
	}
	
}
