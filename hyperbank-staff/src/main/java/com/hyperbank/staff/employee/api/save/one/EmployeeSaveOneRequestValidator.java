package com.hyperbank.staff.employee.api.save.one;

import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.paulmarcelinbejan.architecture.sniper.validator.jakarta.impl.JakartaBaseValidator;
import com.paulmarcelinbejan.toolbox.utils.validation.stereotype.Validator;

@Validator
public interface EmployeeSaveOneRequestValidator extends JakartaBaseValidator<EmployeeSaveRequest> {
	
}
