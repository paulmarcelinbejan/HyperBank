package com.hyperbank.staff.employee.api.delete.one;

import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.staff.employee.repository.EmployeeRepository;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmployeeDeleteOneServiceImpl implements EmployeeDeleteOneService {

	private final EmployeeRepository repository;

	@Override
	@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
	public void execute(Long id) throws FunctionalException, TechnicalException {
		
		repository.deleteById(id);
	
	}
	
}
