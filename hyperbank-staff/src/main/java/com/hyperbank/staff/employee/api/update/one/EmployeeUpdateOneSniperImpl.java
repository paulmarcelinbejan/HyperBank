package com.hyperbank.staff.employee.api.update.one;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeUpdateRequest;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.sniper.base.SniperFull;

public class EmployeeUpdateOneSniperImpl extends SniperFull<EmployeeUpdateRequest, Employee, Employee, EmployeeResponse> implements EmployeeUpdateOneSniper {

	public EmployeeUpdateOneSniperImpl(
			EmployeeUpdateOneRequestValidator validator,
			EmployeeUpdateOneMapper mapper, 
			EmployeeUpdateOneService service) {
		super(validator, mapper, service, mapper);
	}
	
}
