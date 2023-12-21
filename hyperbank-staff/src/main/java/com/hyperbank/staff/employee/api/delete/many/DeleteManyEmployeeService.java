package com.hyperbank.staff.employee.api.delete.many;

import java.util.List;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface DeleteManyEmployeeService extends ServiceInputAware<List<Long>> {

	/**
	 * Delete many employee by IDs
	 */
	@Override
	void execute(List<Long> ids) throws FunctionalException, TechnicalException;
	
}
