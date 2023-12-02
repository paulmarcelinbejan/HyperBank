package com.hyperbank.staff.employee.api.save.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.paulmarcelinbejan.architecture.sniper.SniperRequestResponseAware;

public interface EmployeeSaveManySniper extends SniperRequestResponseAware<List<EmployeeSaveRequest>, List<EmployeeResponse>> {
	
}
