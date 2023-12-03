package com.hyperbank.staff.employee.api.save.one;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.staff.employee.entity.Employee;
import com.hyperbank.staff.employee.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaveOneEmployeeServiceImpl implements SaveOneEmployeeService {

	private final EmployeeRepository repository;

	@Override
	@Transactional
	public Employee execute(Employee entity) {
		
		return repository.save(entity);
		
	}
	
}
