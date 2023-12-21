package com.hyperbank.staff.employee.api.update.many;

import java.util.List;

import com.hyperbank.staff.employee.entity.Employee;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

public interface UpdateManyEmployeeService extends ServiceInputOutputAware<List<Employee>, List<Employee>> {

	/**
	 * Update many employee
	 */
	@Override
	List<Employee> execute(List<Employee> employee) throws FunctionalException, TechnicalException;
	
}
