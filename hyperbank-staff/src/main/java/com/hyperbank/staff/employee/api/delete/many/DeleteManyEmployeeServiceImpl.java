package com.hyperbank.staff.employee.api.delete.many;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.staff.employee.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteManyEmployeeServiceImpl implements DeleteManyEmployeeService {

	private final EmployeeRepository repository;
	
	/**
	 * DELETE ALL BY ID
	 * <br>Entities that aren't found in the persistence store are silently ignored.
	 */
	@Override
	@Transactional
	public void execute(List<Long> ids) {
		
		repository.deleteAllById(ids);
		
	}
	
}
