package com.hyperbank.staff.employee.api.delete.one;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.staff.employee.repository.EmployeeRepository;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteOneEmployeeServiceImpl implements DeleteOneEmployeeService {

	private final EmployeeRepository repository;

	@Override
	@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
	public void execute(Long id) throws FunctionalException, TechnicalException {
		
		repository.deleteById(id);
	
	}
	
}
