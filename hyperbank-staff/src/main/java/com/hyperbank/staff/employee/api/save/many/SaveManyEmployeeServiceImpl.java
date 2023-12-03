package com.hyperbank.staff.employee.api.save.many;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.staff.employee.entity.Employee;
import com.hyperbank.staff.employee.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaveManyEmployeeServiceImpl implements SaveManyEmployeeService {

	private final EmployeeRepository repository;

	@Override
	@Transactional
	public List<Employee> execute(List<Employee> entities) {

		return repository.saveAll(entities);
		
	}
	
}
