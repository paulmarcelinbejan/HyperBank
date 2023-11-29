package com.hyperbank.staff.employee.api.delete.one;

import com.paulmarcelinbejan.architecture.sniper.base.BaseSniper;
import com.paulmarcelinbejan.architecture.sniper.stereotype.Sniper;

@Sniper
public class EmployeeDeleteOneSniper extends BaseSniper<Long, Long, Void, Void> {

	public EmployeeDeleteOneSniper(
			EmployeeDeleteOneRequestValidator validator,
			EmployeeDeleteOneMapper mapper, 
			EmployeeDeleteOneService service) {
		super(validator, mapper, service, mapper);
	}
	
}
