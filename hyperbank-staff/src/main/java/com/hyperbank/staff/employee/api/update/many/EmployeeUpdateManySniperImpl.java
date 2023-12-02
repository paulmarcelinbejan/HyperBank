package com.hyperbank.staff.employee.api.update.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeUpdateRequest;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.sniper.base.SniperFull;

public class EmployeeUpdateManySniperImpl extends SniperFull<List<EmployeeUpdateRequest>, List<Employee>, List<Employee>, List<EmployeeResponse>> implements EmployeeUpdateManySniper {

	public EmployeeUpdateManySniperImpl(
			EmployeeUpdateManyRequestValidator validator,
			EmployeeUpdateManyMapper mapper, 
			EmployeeUpdateManyService service) {
		super(validator, mapper, service, mapper);
	}
	
}
