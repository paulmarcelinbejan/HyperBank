package com.hyperbank.staff.employee.api.save.one;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.paulmarcelinbejan.architecture.sniper.SniperRequestResponseAware;
import com.paulmarcelinbejan.architecture.sniper.stereotype.Sniper;

@Sniper
public interface EmployeeSaveOneSniper extends SniperRequestResponseAware<EmployeeSaveRequest, EmployeeResponse> {
	
}
