package com.hyperbank.staff.employee.api.find.all;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.staff.employee.entity.Employee;
import com.hyperbank.staff.employee.repository.EmployeeRepository;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.impl.ReadServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.utils.ServiceHelperUtils;

@Service
@Transactional(readOnly = true)
public class EmployeeFindAllServiceImpl implements EmployeeFindAllService {

	public EmployeeFindAllServiceImpl(EmployeeRepository employeeRepository) {
		readServiceHelper = new ReadServiceHelperImpl<>(employeeRepository, ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(Employee.class));
	}

	private final ReadServiceHelper<Long, Employee> readServiceHelper;

	@Override
	public List<Employee> execute(Void nothing) throws FunctionalException, TechnicalException {
		return readServiceHelper.findAll();
	}
	
}
