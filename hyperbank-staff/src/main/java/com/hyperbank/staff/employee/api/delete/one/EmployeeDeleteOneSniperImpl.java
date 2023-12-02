package com.hyperbank.staff.employee.api.delete.one;

import com.hyperbank.architecture.web.validator.id.base.LongIdValidator;
import com.paulmarcelinbejan.architecture.sniper.base.SniperWithoutMappings;

public class EmployeeDeleteOneSniperImpl extends SniperWithoutMappings<Long> implements EmployeeDeleteOneSniper {

	public EmployeeDeleteOneSniperImpl(
			LongIdValidator validator,
			EmployeeDeleteOneService service) {
		super(validator, service);
	}
	
}
