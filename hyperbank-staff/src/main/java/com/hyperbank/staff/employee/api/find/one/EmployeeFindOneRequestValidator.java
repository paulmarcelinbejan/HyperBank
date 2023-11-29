package com.hyperbank.staff.employee.api.find.one;

import com.paulmarcelinbejan.architecture.sniper.validator.jakarta.JakartaBaseValidator;
import com.paulmarcelinbejan.toolbox.utils.validation.stereotype.Validator;

import jakarta.validation.ValidationException;

@Validator
public class EmployeeFindOneRequestValidator implements JakartaBaseValidator<Long> {
	
	@Override
	public void validate(Long id) {
		if(id == null) {
			throw new ValidationException("Request can not be null.");
		}
		if(id <= 0) {
			throw new ValidationException("Id can not be less or equal to 0.");
		}
	}
	
}
