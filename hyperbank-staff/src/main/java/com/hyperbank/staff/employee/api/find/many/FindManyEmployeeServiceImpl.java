package com.hyperbank.staff.employee.api.find.many;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.staff.employee.entity.Employee;
import com.hyperbank.staff.employee.repository.EmployeeRepository;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindManyEmployeeServiceImpl implements FindManyEmployeeService {
	
	private final EmployeeRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Employee> execute(List<Long> ids) throws FunctionalException, TechnicalException {
		
		return repository.findAllById(ids);
		
	}
	
}
