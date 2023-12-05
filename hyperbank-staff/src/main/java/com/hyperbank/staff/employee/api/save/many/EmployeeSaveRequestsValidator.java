package com.hyperbank.staff.employee.api.save.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.validator.jakarta.JakartaCollectionValidator;

public interface EmployeeSaveRequestsValidator extends JakartaCollectionValidator<EmployeeSaveRequest, List<EmployeeSaveRequest>> {
	
}
