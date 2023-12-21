package com.hyperbank.staff.employee.api.save.one;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface SaveOneEmployeeCoordinator extends CoordinatorRequestResponseAware<EmployeeSaveRequest, EmployeeResponse> {
	
	/**
	 * Save employee by request
	 */
	@Override
	EmployeeResponse process(EmployeeSaveRequest request) throws FunctionalException, TechnicalException;
	
}
