package com.hyperbank.staff.employee.api.find.many;

import java.util.List;

import com.hyperbank.staff.employee.entity.Employee;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface FindManyEmployeeService extends ServiceInputOutputAware<List<Long>, List<Employee>> {

	/**
	 * Find many employee by IDs
	 */
	@Override
	List<Employee> execute(List<Long> ids) throws FunctionalException, TechnicalException;
	
}
