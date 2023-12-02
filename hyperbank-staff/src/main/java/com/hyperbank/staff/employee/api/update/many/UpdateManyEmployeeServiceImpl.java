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
public class UpdateManyEmployeeServiceImpl implements UpdateManyEmployeeService {

	private final EmployeeRepository repository; 

	@Override
	@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
	public List<Employee> execute(List<Employee> entities) throws FunctionalException, TechnicalException {
		
		return repository.saveAll(entities);
		
	}
	
}
