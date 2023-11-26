package com.hyperbank.staff.employee.api.save.one;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.staff.employee.entity.Employee;
import com.hyperbank.staff.employee.repository.EmployeeRepository;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.service.helper.CreateServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.impl.CreateServiceHelperImpl;

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class EmployeeSaveOneServiceImpl implements EmployeeSaveOneService {

	public EmployeeSaveOneServiceImpl(EmployeeRepository employeeRepository) {
		createServiceHelper = new CreateServiceHelperImpl<>(employeeRepository, Employee::getId);
	}

	private final CreateServiceHelper<Long, Employee> createServiceHelper;

	@Override
	public Employee execute(Employee employee) throws FunctionalException, TechnicalException {
		return createServiceHelper.saveAndReturn(employee);
	}
	
}
