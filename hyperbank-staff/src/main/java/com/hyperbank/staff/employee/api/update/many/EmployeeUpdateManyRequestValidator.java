package com.hyperbank.staff.employee.api.update.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeUpdateRequest;
import com.paulmarcelinbejan.architecture.sniper.validator.jakarta.impl.JakartaCollectionValidator;
import com.paulmarcelinbejan.toolbox.utils.validation.stereotype.Validator;

@Validator
public interface EmployeeUpdateManyRequestValidator extends JakartaCollectionValidator<EmployeeUpdateRequest, List<EmployeeUpdateRequest>> {
	
}
