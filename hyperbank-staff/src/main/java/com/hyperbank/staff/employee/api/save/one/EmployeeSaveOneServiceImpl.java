package com.hyperbank.staff.employee.api.save.one;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.staff.employee.entity.Employee;
import com.hyperbank.staff.employee.repository.EmployeeRepository;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeSaveOneServiceImpl implements EmployeeSaveOneService {

	private final EmployeeRepository repository;

	@Override
	@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
	public Employee execute(Employee entity) throws FunctionalException, TechnicalException {
		
		return repository.save(entity);
		
	}
	
}
