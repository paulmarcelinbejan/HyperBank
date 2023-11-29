package com.hyperbank.staff.employee.api.save.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.paulmarcelinbejan.architecture.sniper.validator.jakarta.JakartaCollectionValidator;
import com.paulmarcelinbejan.toolbox.utils.validation.stereotype.Validator;

@Validator
public class EmployeeSaveManyRequestValidator implements JakartaCollectionValidator<EmployeeSaveRequest, List<EmployeeSaveRequest>> {
	
}
