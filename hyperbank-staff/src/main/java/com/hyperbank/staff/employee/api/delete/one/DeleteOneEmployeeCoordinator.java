package com.hyperbank.staff.employee.api.delete.one;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface DeleteOneEmployeeCoordinator extends CoordinatorRequestAware<Long> {
	
	/**
	 * Delete one employee by id
	 */
	@Override
	void process(Long id) throws FunctionalException, TechnicalException;
	
}
