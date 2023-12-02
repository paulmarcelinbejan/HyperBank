package com.hyperbank.staff.employee.api.update.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeUpdateRequest;
import com.paulmarcelinbejan.architecture.coordinator.validator.jakarta.impl.JakartaCollectionValidator;

public interface UpdateManyRequestEmployeeValidator extends JakartaCollectionValidator<EmployeeUpdateRequest, List<EmployeeUpdateRequest>> {
	
}
