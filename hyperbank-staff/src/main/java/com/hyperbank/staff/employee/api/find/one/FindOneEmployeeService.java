package com.hyperbank.staff.employee.api.find.one;

import com.hyperbank.staff.employee.entity.Employee;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;

public interface FindOneEmployeeService extends ServiceInputOutputAware<Long, Employee> {

	/**
	 * Find employee by ID
	 */
	@Override
	Employee execute(Long id) throws FunctionalException;
	
}
