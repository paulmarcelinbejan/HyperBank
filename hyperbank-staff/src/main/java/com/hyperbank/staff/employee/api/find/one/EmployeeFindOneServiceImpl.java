package com.hyperbank.staff.employee.api.find.one;

import java.text.MessageFormat;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.staff.employee.entity.Employee;
import com.hyperbank.staff.employee.repository.EmployeeRepository;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.service.helper.utils.ServiceHelperUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeFindOneServiceImpl implements EmployeeFindOneService {

	private final EmployeeRepository repository;

	@Override
	@Transactional(readOnly = true)
	public Employee execute(Long id) throws FunctionalException, TechnicalException {
		
		return repository.findById(id)
				.orElseThrow(() -> new FunctionalException(MessageFormat.format(ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(Employee.class), id)));
	
	}
	
}
