package com.hyperbank.staff.employee.api.update.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeUpdateRequest;
import com.paulmarcelinbejan.architecture.sniper.validator.jakarta.impl.JakartaCollectionValidator;

public interface EmployeeUpdateManyRequestValidator extends JakartaCollectionValidator<EmployeeUpdateRequest, List<EmployeeUpdateRequest>> {
	
}
