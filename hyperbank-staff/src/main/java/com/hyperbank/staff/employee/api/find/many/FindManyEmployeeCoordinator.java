package com.hyperbank.staff.employee.api.find.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindManyEmployeeCoordinator extends CoordinatorRequestResponseAware<List<Long>, List<EmployeeResponse>> {
	
	/**
	 * Find many employee by IDs
	 */
	@Override
	List<EmployeeResponse> process(List<Long> ids) throws FunctionalException, TechnicalException;
	
}
