package com.hyperbank.staff.employee.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.staff.employee.entity.Employee;
import com.hyperbank.staff.employee.mapper.EmployeeMapper;
import com.hyperbank.staff.employee.repository.EmployeeRepository;
import com.hyperbank.staff.employee.service.EmployeeService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.service.helper.CreateServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.DeleteServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.UpdateServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.impl.CreateServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.impl.DeleteServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.impl.ReadServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.impl.UpdateServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.utils.ServiceHelperUtils;

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class EmployeeServiceImpl implements EmployeeService {

	public EmployeeServiceImpl(EmployeeMapper employeeMapper, EmployeeRepository employeeRepository) {
		createServiceHelper = new CreateServiceHelperImpl<>(employeeRepository, Employee::getId);
		readServiceHelper = new ReadServiceHelperImpl<>(employeeRepository, ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(Employee.class));
		updateServiceHelper = new UpdateServiceHelperImpl<>(
				employeeRepository,
				employeeMapper,
				readServiceHelper,
				Employee::getId);
		deleteServiceHelper = new DeleteServiceHelperImpl<>(employeeRepository, readServiceHelper);
	}

	private final CreateServiceHelper<Long, Employee> createServiceHelper;
	private final ReadServiceHelper<Long, Employee> readServiceHelper;
	private final UpdateServiceHelper<Long, Employee> updateServiceHelper;
	private final DeleteServiceHelper<Long> deleteServiceHelper;

	@Override
	@Transactional(readOnly = true)
	public Employee getReferenceById(Long id) {
		return readServiceHelper.getReferenceById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Employee findById(Long id) throws FunctionalException {
		return readServiceHelper.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Employee> findManyById(Collection<Long> ids) throws FunctionalException {
		return readServiceHelper.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Employee> findManyByIdIfPresent(Collection<Long> ids) {
		return readServiceHelper.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Employee> findAll() {
		return readServiceHelper.findAll();
	}

	@Override
	public Long save(Employee entity) throws FunctionalException {
		return createServiceHelper.save(entity);
	}

	@Override
	public Employee saveAndReturn(Employee entity) throws FunctionalException {
		return createServiceHelper.saveAndReturn(entity);
	}

	@Override
	public List<Long> save(Collection<Employee> entities) throws FunctionalException {
		return createServiceHelper.save(entities);
	}

	@Override
	public List<Employee> saveAndReturn(Collection<Employee> entities) throws FunctionalException {
		return createServiceHelper.saveAndReturn(entities);
	}

	@Override
	public Long update(Employee entity) throws FunctionalException {
		return updateServiceHelper.update(entity);
	}

	@Override
	public Employee updateAndReturn(Employee entity) throws FunctionalException {
		return updateServiceHelper.updateAndReturn(entity);
	}
	
	@Override
	public List<Long> update(Collection<Employee> entities) throws FunctionalException {
		return updateServiceHelper.update(entities);
	}
	
	@Override
	public List<Employee> updateAndReturn(Collection<Employee> entities) throws FunctionalException {
		return updateServiceHelper.updateAndReturn(entities);
	}

	@Override
	public void delete(Long id) throws FunctionalException {
		deleteServiceHelper.delete(id);
	}
	
	@Override
	public void deleteIfPresent(Long id) {
		deleteServiceHelper.deleteIfPresent(id);
	}

	@Override
	public void deleteMany(Collection<Long> ids) throws FunctionalException {
		deleteServiceHelper.deleteMany(ids);
	}

	@Override
	public void deleteManyIfPresent(Collection<Long> ids) {
		deleteServiceHelper.deleteManyIfPresent(ids);
	}
	
}
