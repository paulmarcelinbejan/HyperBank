package com.hyperbank.staff.employee.api.find.all;

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
public class EmployeeFindAllServiceImpl implements EmployeeFindAllService {

	private final EmployeeRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Employee> execute() throws FunctionalException, TechnicalException {
		
		return repository.findAll();
		
	}
	
}
