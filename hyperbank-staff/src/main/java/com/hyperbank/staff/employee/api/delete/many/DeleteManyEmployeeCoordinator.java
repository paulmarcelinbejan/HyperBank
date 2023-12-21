package com.hyperbank.staff.employee.api.delete.many;

import java.util.List;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface DeleteManyEmployeeCoordinator extends CoordinatorRequestAware<List<Long>> {
	
	/**
	 * Delete many employee by IDs
	 */
	@Override
	void process(List<Long> ids) throws FunctionalException, TechnicalException;
	
}
