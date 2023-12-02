package com.hyperbank.staff.employee.api.find.many;

import java.util.List;

import com.hyperbank.architecture.web.validator.id.base.LongIdsValidator;
import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.sniper.base.SniperWithoutInputMapping;
import com.paulmarcelinbejan.architecture.sniper.stereotype.Sniper;

@Sniper
public class EmployeeFindManySniperImpl extends SniperWithoutInputMapping<List<Long>, List<Employee>, List<EmployeeResponse>> implements EmployeeFindManySniper {

	public EmployeeFindManySniperImpl(
			LongIdsValidator validator,
			EmployeeFindManyService service,
			EmployeeFindManyMapper mapper) {
		super(validator, service, mapper);
	}
	
}
