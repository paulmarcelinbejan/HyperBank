package com.hyperbank.staff.employee.api.find.all;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.sniper.base.SniperServiceResponse;
import com.paulmarcelinbejan.architecture.sniper.stereotype.Sniper;

@Sniper
public class EmployeeFindAllSniperImpl extends SniperServiceResponse<List<Employee>, List<EmployeeResponse>> implements EmployeeFindAllSniper {

	public EmployeeFindAllSniperImpl(
			EmployeeFindAllService service,
			EmployeeFindAllMapper mapper) {
		super(service, mapper);
	}
	
}
