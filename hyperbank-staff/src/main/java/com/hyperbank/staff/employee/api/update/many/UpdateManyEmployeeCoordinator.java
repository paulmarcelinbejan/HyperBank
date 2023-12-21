package com.hyperbank.staff.employee.api.update.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeUpdateRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface UpdateManyEmployeeCoordinator extends CoordinatorRequestResponseAware<List<EmployeeUpdateRequest>, List<EmployeeResponse>> {
	
	/**
	 * Update many employee by requests
	 */
	@Override
	List<EmployeeResponse> process(List<EmployeeUpdateRequest> requests) throws FunctionalException, TechnicalException;
	
}
