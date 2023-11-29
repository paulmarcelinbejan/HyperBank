package com.hyperbank.staff.employee.api.update.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeUpdateRequest;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.sniper.base.BaseSniper;
import com.paulmarcelinbejan.architecture.sniper.stereotype.Sniper;

@Sniper
public class EmployeeUpdateManySniper extends BaseSniper<List<EmployeeUpdateRequest>, List<Employee>, List<Employee>, List<EmployeeResponse>> {

	public EmployeeUpdateManySniper(
			EmployeeUpdateManyRequestValidator validator,
			EmployeeUpdateManyMapper mapper, 
			EmployeeUpdateManyService service) {
		super(validator, mapper, service, mapper);
	}
	
}
