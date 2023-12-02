package com.hyperbank.staff.employee.api.save.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.paulmarcelinbejan.architecture.sniper.validator.jakarta.impl.JakartaCollectionValidator;

public interface EmployeeSaveManyRequestValidator extends JakartaCollectionValidator<EmployeeSaveRequest, List<EmployeeSaveRequest>> {
	
}
