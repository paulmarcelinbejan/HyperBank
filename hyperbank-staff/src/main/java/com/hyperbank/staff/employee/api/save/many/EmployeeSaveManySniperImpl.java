package com.hyperbank.staff.employee.api.save.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.sniper.base.SniperFull;
import com.paulmarcelinbejan.architecture.sniper.stereotype.Sniper;

@Sniper
public class EmployeeSaveManySniperImpl extends SniperFull<List<EmployeeSaveRequest>, List<Employee>, List<Employee>, List<EmployeeResponse>> implements EmployeeSaveManySniper {

	public EmployeeSaveManySniperImpl(
			EmployeeSaveManyRequestValidator validator,
			EmployeeSaveManyMapper mapper, 
			EmployeeSaveManyService service) {
		super(validator, mapper, service, mapper);
	}
	
}
