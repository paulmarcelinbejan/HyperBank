package com.hyperbank.staff.employee.api.update.one;

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
public class EmployeeUpdateOneServiceImpl implements EmployeeUpdateOneService {

	private final EmployeeRepository employeeRepository; 

	@Override
	public Employee execute(Employee employee) throws FunctionalException, TechnicalException {
		return employeeRepository.save(employee);
	}
	
}
