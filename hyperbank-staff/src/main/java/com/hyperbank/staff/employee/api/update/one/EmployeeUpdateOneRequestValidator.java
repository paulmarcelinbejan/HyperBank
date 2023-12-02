package com.hyperbank.staff.employee.api.update.one;

import com.hyperbank.staff.employee.dto.EmployeeUpdateRequest;
import com.paulmarcelinbejan.architecture.sniper.validator.jakarta.impl.JakartaBaseValidator;
import com.paulmarcelinbejan.toolbox.utils.validation.stereotype.Validator;

@Validator
public interface EmployeeUpdateOneRequestValidator extends JakartaBaseValidator<EmployeeUpdateRequest> {
	
}
