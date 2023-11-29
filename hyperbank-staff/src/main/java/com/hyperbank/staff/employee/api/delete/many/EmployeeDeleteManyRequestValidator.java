package com.hyperbank.staff.employee.api.delete.many;

import java.util.List;

import com.paulmarcelinbejan.architecture.sniper.validator.id.IdsValidator;
import com.paulmarcelinbejan.toolbox.utils.validation.stereotype.Validator;

@Validator
public class EmployeeDeleteManyRequestValidator implements IdsValidator<Long, List<Long>> {

	@Override
	public Long getZeroValue() {
		return 0L;
	}
	
}
