package com.hyperbank.staff.employee.api.update.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeUpdateRequest;
import com.paulmarcelinbejan.architecture.sniper.validator.jakarta.JakartaCollectionValidator;
import com.paulmarcelinbejan.toolbox.utils.validation.stereotype.Validator;

@Validator
public class EmployeeUpdateManyRequestValidator implements JakartaCollectionValidator<EmployeeUpdateRequest, List<EmployeeUpdateRequest>> {
	
}
