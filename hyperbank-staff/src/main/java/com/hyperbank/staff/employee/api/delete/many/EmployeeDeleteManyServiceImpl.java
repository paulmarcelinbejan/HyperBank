package com.hyperbank.staff.employee.api.delete.many;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.staff.employee.entity.Employee;
import com.hyperbank.staff.employee.repository.EmployeeRepository;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.service.helper.DeleteServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.impl.DeleteServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.impl.ReadServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.utils.ServiceHelperUtils;

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class EmployeeDeleteManyServiceImpl implements EmployeeDeleteManyService {

	public EmployeeDeleteManyServiceImpl(EmployeeRepository employeeRepository) {
		ReadServiceHelper<Long, Employee> readServiceHelper = new ReadServiceHelperImpl<>(employeeRepository, ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(Employee.class));
		deleteServiceHelper = new DeleteServiceHelperImpl<>(employeeRepository, readServiceHelper);
	}

	private final DeleteServiceHelper<Long> deleteServiceHelper;

	@Override
	public Void execute(List<Long> ids) throws FunctionalException, TechnicalException {
		deleteServiceHelper.deleteMany(ids);
		return null;
	}
	
}
