package com.hyperbank.staff.employee.api.delete.one;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface DeleteOneEmployeeService extends ServiceInputAware<Long> {

	/**
	 * Delete employee by ID
	 */
	@Override
	void execute(Long id) throws FunctionalException, TechnicalException;
	
}
