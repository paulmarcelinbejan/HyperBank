package com.hyperbank.staff.employee.api.find.one;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.sniper.base.BaseSniper;
import com.paulmarcelinbejan.architecture.sniper.stereotype.Sniper;

@Sniper
public class EmployeeFindOneSniper extends BaseSniper<Long, Long, Employee, EmployeeResponse> {

	public EmployeeFindOneSniper(
			EmployeeFindOneRequestValidator validator,
			EmployeeFindOneMapper mapper, 
			EmployeeFindOneService service) {
		super(validator, mapper, service, mapper);
	}
	
}
