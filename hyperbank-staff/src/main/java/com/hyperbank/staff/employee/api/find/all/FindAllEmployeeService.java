package com.hyperbank.staff.employee.api.find.all;

import java.util.List;

import com.hyperbank.staff.employee.entity.Employee;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindAllEmployeeService extends ServiceOutputAware<List<Employee>> {

	/**
	 * Find all employee
	 */
	@Override
	List<Employee> execute() throws FunctionalException, TechnicalException;
	
}
