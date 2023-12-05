package com.hyperbank.staff.employee.api.update.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeUpdateRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.validator.jakarta.JakartaCollectionValidator;

public interface EmployeeUpdateRequestsValidator extends JakartaCollectionValidator<EmployeeUpdateRequest, List<EmployeeUpdateRequest>> {
	
}
