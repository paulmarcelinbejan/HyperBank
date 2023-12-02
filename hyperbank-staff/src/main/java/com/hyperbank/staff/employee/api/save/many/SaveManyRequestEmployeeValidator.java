package com.hyperbank.staff.employee.api.save.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.paulmarcelinbejan.architecture.coordinator.validator.jakarta.impl.JakartaCollectionValidator;

public interface SaveManyRequestEmployeeValidator extends JakartaCollectionValidator<EmployeeSaveRequest, List<EmployeeSaveRequest>> {
	
}
