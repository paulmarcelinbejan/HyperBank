package com.hyperbank.staff.employee.api.update.one;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeUpdateRequest;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.sniper.base.BaseSniper;
import com.paulmarcelinbejan.architecture.sniper.stereotype.Sniper;

@Sniper
public class EmployeeUpdateOneSniper extends BaseSniper<EmployeeUpdateRequest, Employee, Employee, EmployeeResponse> {

	public EmployeeUpdateOneSniper(
			EmployeeUpdateOneRequestValidator validator,
			EmployeeUpdateOneMapper mapper, 
			EmployeeUpdateOneService service) {
		super(validator, mapper, service, mapper);
	}
	
}
