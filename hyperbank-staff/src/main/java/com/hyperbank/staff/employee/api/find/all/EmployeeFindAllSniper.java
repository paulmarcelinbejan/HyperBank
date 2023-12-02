package com.hyperbank.staff.employee.api.find.all;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.paulmarcelinbejan.architecture.sniper.SniperResponseAware;
import com.paulmarcelinbejan.architecture.sniper.stereotype.Sniper;

@Sniper
public interface EmployeeFindAllSniper extends SniperResponseAware<List<EmployeeResponse>> {
	
}
