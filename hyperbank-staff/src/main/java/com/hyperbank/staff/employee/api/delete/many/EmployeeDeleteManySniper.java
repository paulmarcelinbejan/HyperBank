package com.hyperbank.staff.employee.api.delete.many;

import java.util.List;

import com.paulmarcelinbejan.architecture.sniper.base.BaseSniper;
import com.paulmarcelinbejan.architecture.sniper.stereotype.Sniper;

@Sniper
public class EmployeeDeleteManySniper extends BaseSniper<List<Long>, List<Long>, Void, Void> {

	public EmployeeDeleteManySniper(
			EmployeeDeleteManyRequestValidator validator,
			EmployeeDeleteManyMapper mapper, 
			EmployeeDeleteManyService service) {
		super(validator, mapper, service, mapper);
	}
	
}
