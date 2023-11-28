package com.hyperbank.staff.employee.api.find.many;

import java.util.List;

import com.paulmarcelinbejan.architecture.sniper.validator.CollectionValidator;
import com.paulmarcelinbejan.toolbox.utils.validation.stereotype.Validator;

import jakarta.validation.ValidationException;

@Validator
public class EmployeeFindManyRequestValidator implements CollectionValidator<Long, List<Long>> {
	
	@Override
	public void validate(List<Long> request) {
		for(Long id : request) {
			if(id == null) {
				throw new ValidationException("Request can not be null.");
			}
			if(id <= 0) {
				throw new ValidationException("Id can not be less or equal to 0.");
			}
		}
	}
	
}
