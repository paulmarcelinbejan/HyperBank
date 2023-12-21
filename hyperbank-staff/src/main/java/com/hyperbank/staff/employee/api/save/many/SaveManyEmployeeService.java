package com.hyperbank.staff.employee.api.save.many;

import java.util.List;

import com.hyperbank.staff.employee.entity.Employee;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface SaveManyEmployeeService extends ServiceInputOutputAware<List<Employee>, List<Employee>> {

	/**
	 * Save many employee
	 */
	@Override
	List<Employee> execute(List<Employee> employee) throws FunctionalException, TechnicalException;
	
}
