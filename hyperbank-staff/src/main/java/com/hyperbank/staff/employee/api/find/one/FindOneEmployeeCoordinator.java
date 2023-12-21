package com.hyperbank.staff.employee.api.find.one;

import com.hyperbank.staff.employee.dto.EmployeeResponse;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindOneEmployeeCoordinator extends CoordinatorRequestResponseAware<Long, EmployeeResponse> {
	
	/**
	 * Find employee by id
	 */
	@Override
	EmployeeResponse process(Long id) throws FunctionalException, TechnicalException;
	
}
