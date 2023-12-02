package com.hyperbank.staff.employee.api.find.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.paulmarcelinbejan.architecture.sniper.SniperRequestResponseAware;

public interface EmployeeFindManySniper extends SniperRequestResponseAware<List<Long>, List<EmployeeResponse>> {
	
}
