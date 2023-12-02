package com.hyperbank.staff.employee.api.delete.many;

import java.util.List;

import com.hyperbank.architecture.web.validator.id.base.LongIdsValidator;
import com.paulmarcelinbejan.architecture.sniper.base.SniperWithoutMappings;

public class EmployeeDeleteManySniperImpl extends SniperWithoutMappings<List<Long>> implements EmployeeDeleteManySniper {

	public EmployeeDeleteManySniperImpl(
			LongIdsValidator validator,
			EmployeeDeleteManyService service) {
		super(validator, service);
	}
	
}
