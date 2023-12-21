package com.hyperbank.staff.employee.api.find.all;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindAllEmployeeCoordinator extends CoordinatorResponseAware<List<EmployeeResponse>> {

	/**
	 * Find all employee
	 */
	@Override
	List<EmployeeResponse> process() throws FunctionalException, TechnicalException;
	
}
