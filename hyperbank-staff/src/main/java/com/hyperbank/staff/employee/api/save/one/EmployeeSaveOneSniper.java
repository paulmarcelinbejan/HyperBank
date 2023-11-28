package com.hyperbank.staff.employee.api.save.one;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.sniper.base.BaseSniper;
import com.paulmarcelinbejan.architecture.sniper.stereotype.Sniper;

@Sniper
public class EmployeeSaveOneSniper extends BaseSniper<EmployeeSaveRequest, Employee, Employee, EmployeeResponse> {

	public EmployeeSaveOneSniper(
			EmployeeSaveOneRequestValidator validator,
			EmployeeSaveOneMapper mapper, 
			EmployeeSaveOneService service) {
		super(validator, mapper, service, mapper);
	}
	
}
