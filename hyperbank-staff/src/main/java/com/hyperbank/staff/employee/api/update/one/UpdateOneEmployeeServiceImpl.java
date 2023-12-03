package com.hyperbank.staff.employee.api.update.one;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.staff.employee.entity.Employee;
import com.hyperbank.staff.employee.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateOneEmployeeServiceImpl implements UpdateOneEmployeeService {

	private final EmployeeRepository repository; 

	@Override
	@Transactional
	public Employee execute(Employee employee) {
		
		return repository.save(employee);
		
	}
	
}
