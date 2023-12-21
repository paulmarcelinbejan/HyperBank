package com.hyperbank.staff.employee.api.update.one;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeUpdateRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface UpdateOneEmployeeCoordinator extends CoordinatorRequestResponseAware<EmployeeUpdateRequest, EmployeeResponse> {
	
	/**
	 * Update employee by request
	 */
	@Override
	EmployeeResponse process(EmployeeUpdateRequest request) throws FunctionalException, TechnicalException;
	
}
