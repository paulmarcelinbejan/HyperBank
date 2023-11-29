package com.hyperbank.staff.employee.api.delete.one;

import com.paulmarcelinbejan.architecture.sniper.validator.id.IdValidator;
import com.paulmarcelinbejan.toolbox.utils.validation.stereotype.Validator;

@Validator
public class EmployeeDeleteOneRequestValidator implements IdValidator<Long> {

	@Override
	public Long getZeroValue() {
		return 0L;
	}
	
}
