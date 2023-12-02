package com.hyperbank.staff.employee.api.save.one;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.sniper.base.SniperFull;
import com.paulmarcelinbejan.architecture.sniper.stereotype.Sniper;

@Sniper
public class EmployeeSaveOneSniperImpl extends SniperFull<EmployeeSaveRequest, Employee, Employee, EmployeeResponse> implements EmployeeSaveOneSniper {

	public EmployeeSaveOneSniperImpl(
			EmployeeSaveOneRequestValidator validator,
			EmployeeSaveOneMapper mapper, 
			EmployeeSaveOneService service) {
		super(validator, mapper, service, mapper);
	}
	
}
