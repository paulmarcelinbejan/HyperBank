package com.hyperbank.staff.employee.api.save.one;

import com.hyperbank.staff.employee.entity.Employee;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface SaveOneEmployeeService extends ServiceInputOutputAware<Employee, Employee> {

	/**
	 * Save employee
	 */
	@Override
	Employee execute(Employee employee) throws FunctionalException, TechnicalException;
	
}
