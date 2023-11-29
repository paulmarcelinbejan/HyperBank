package com.hyperbank.staff.employee.api.update.many;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.staff.employee.entity.Employee;
import com.hyperbank.staff.employee.repository.EmployeeRepository;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class EmployeeUpdateManyServiceImpl implements EmployeeUpdateManyService {

	private final EmployeeRepository employeeRepository; 

	@Override
	public List<Employee> execute(List<Employee> employees) throws FunctionalException, TechnicalException {
		return employeeRepository.saveAll(employees);
	}
	
}
