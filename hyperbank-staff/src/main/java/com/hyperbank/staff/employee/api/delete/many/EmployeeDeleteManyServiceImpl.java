package com.hyperbank.staff.employee.api.delete.many;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.staff.employee.repository.EmployeeRepository;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmployeeDeleteManyServiceImpl implements EmployeeDeleteManyService {

	private final EmployeeRepository repository;
	
	/**
	 * DELETE ALL BY ID
	 * <br>Entities that aren't found in the persistence store are silently ignored.
	 */
	@Override
	@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
	public void execute(List<Long> ids) throws FunctionalException, TechnicalException {
		
		repository.deleteAllById(ids);
		
	}
	
}
