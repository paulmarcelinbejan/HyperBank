package com.hyperbank.staff.employee.api.find.all;

import com.paulmarcelinbejan.architecture.sniper.validator.BaseValidator;
import com.paulmarcelinbejan.toolbox.utils.validation.stereotype.Validator;

@Validator
public class EmployeeFindAllRequestValidator implements BaseValidator<Void> {
	
	@Override
	public void validate(Void request) {
		// There is nothing to validate
	}

}
