package com.hyperbank.staff.employee.api.delete.one;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.staff.employee.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteOneEmployeeServiceImpl implements DeleteOneEmployeeService {

	private final EmployeeRepository repository;

	@Override
	@Transactional
	public void execute(Long id) {
		
		repository.deleteById(id);
	
	}
	
}
