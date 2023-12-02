package com.hyperbank.staff.employee.api.update.one;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.staff.employee.entity.Employee;
import com.hyperbank.staff.employee.repository.EmployeeRepository;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateOneEmployeeServiceImpl implements UpdateOneEmployeeService {

	private final EmployeeRepository repository; 

	@Override
	@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
	public Employee execute(Employee employee) throws FunctionalException, TechnicalException {
		
		return repository.save(employee);
		
	}
	
}
