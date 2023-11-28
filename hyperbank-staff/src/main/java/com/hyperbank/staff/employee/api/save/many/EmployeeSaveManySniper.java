package com.hyperbank.staff.employee.api.save.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.sniper.base.BaseSniper;
import com.paulmarcelinbejan.architecture.sniper.stereotype.Sniper;

@Sniper
public class EmployeeSaveManySniper extends BaseSniper<List<EmployeeSaveRequest>, List<Employee>, List<Employee>, List<EmployeeResponse>> {

	public EmployeeSaveManySniper(
			EmployeeSaveManyRequestValidator validator,
			EmployeeSaveManyMapper mapper, 
			EmployeeSaveManyService service) {
		super(validator, mapper, service, mapper);
	}
	
}
