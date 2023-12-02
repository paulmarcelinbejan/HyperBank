package com.hyperbank.staff.employee.api.find.one;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.paulmarcelinbejan.architecture.sniper.SniperRequestResponseAware;
import com.paulmarcelinbejan.architecture.sniper.stereotype.Sniper;

@Sniper
public interface EmployeeFindOneSniper extends SniperRequestResponseAware<Long, EmployeeResponse> {
	
}
