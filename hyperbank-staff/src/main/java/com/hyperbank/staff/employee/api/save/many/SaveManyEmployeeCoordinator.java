package com.hyperbank.staff.employee.api.save.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.awareable.CoordinatorRequestResponseAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface SaveManyEmployeeCoordinator extends CoordinatorRequestResponseAware<List<EmployeeSaveRequest>, List<EmployeeResponse>> {
	
	/**
	 * Save many employee by requests
	 */
	@Override
	List<EmployeeResponse> process(List<EmployeeSaveRequest> requests) throws FunctionalException, TechnicalException;
	
}
