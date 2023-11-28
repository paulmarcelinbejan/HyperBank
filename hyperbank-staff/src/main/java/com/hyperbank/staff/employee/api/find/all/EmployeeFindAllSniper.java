package com.hyperbank.staff.employee.api.find.all;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.sniper.base.BaseSniper;
import com.paulmarcelinbejan.architecture.sniper.stereotype.Sniper;

@Sniper
public class EmployeeFindAllSniper extends BaseSniper<Void, Void, List<Employee>, List<EmployeeResponse>> {

	public EmployeeFindAllSniper(
			EmployeeFindAllRequestValidator validator,
			EmployeeFindAllMapper mapper, 
			EmployeeFindAllService service) {
		super(validator, mapper, service, mapper);
	}
	
}
