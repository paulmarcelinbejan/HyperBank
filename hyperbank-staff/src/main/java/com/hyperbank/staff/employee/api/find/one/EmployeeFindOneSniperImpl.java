package com.hyperbank.staff.employee.api.find.one;

import com.hyperbank.architecture.web.validator.id.base.LongIdValidator;
import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.sniper.base.SniperWithoutInputMapping;
import com.paulmarcelinbejan.architecture.sniper.stereotype.Sniper;

@Sniper
public class EmployeeFindOneSniperImpl extends SniperWithoutInputMapping<Long, Employee, EmployeeResponse> implements EmployeeFindOneSniper {

	public EmployeeFindOneSniperImpl(
			LongIdValidator validator,
			EmployeeFindOneMapper mapper, 
			EmployeeFindOneService service) {
		super(validator, service, mapper);
	}
	
}
