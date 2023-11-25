package com.hyperbank.staff.employee.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.staff.employee.entity.Employee;
import com.hyperbank.staff.employee.mapper.EmployeeMapper;
import com.hyperbank.staff.employee.repository.EmployeeRepository;
import com.hyperbank.staff.employee.service.EmployeeService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.web.service.CreateService;
import com.paulmarcelinbejan.toolbox.web.service.DeleteService;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;
import com.paulmarcelinbejan.toolbox.web.service.UpdateService;
import com.paulmarcelinbejan.toolbox.web.service.impl.CreateServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.impl.DeleteServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.impl.ReadServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.impl.UpdateServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.utils.ServiceUtils;

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class EmployeeServiceImpl implements EmployeeService {

	public EmployeeServiceImpl(EmployeeMapper employeeMapper, EmployeeRepository employeeRepository) {
		createService = new CreateServiceImpl<>(employeeRepository, Employee::getId);
		readService = new ReadServiceImpl<>(employeeRepository, ServiceUtils.buildErrorMessageIfEntityNotFoundById(Employee.class));
		updateService = new UpdateServiceImpl<>(
				employeeRepository,
				employeeMapper,
				readService,
				Employee::getId);
		deleteService = new DeleteServiceImpl<>(employeeRepository, readService);
	}

	private final CreateService<Long, Employee> createService;
	private final ReadService<Long, Employee> readService;
	private final UpdateService<Long, Employee> updateService;
	private final DeleteService<Long> deleteService;

	@Override
	@Transactional(readOnly = true)
	public Employee getReferenceById(Long id) {
		return readService.getReferenceById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Employee findById(Long id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Employee> findManyById(Collection<Long> ids) throws FunctionalException {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Employee> findManyByIdIfPresent(Collection<Long> ids) {
		return readService.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Employee> findAll() {
		return readService.findAll();
	}

	@Override
	public Long save(Employee entity) throws FunctionalException {
		return createService.save(entity);
	}

	@Override
	public Employee saveAndReturn(Employee entity) throws FunctionalException {
		return createService.saveAndReturn(entity);
	}

	@Override
	public Collection<Long> save(Collection<Employee> entities) throws FunctionalException {
		return createService.save(entities);
	}

	@Override
	public Collection<Employee> saveAndReturn(Collection<Employee> entities) throws FunctionalException {
		return createService.saveAndReturn(entities);
	}

	@Override
	public Long update(Employee entity) throws FunctionalException {
		return updateService.update(entity);
	}

	@Override
	public Employee updateAndReturn(Employee entity) throws FunctionalException {
		return updateService.updateAndReturn(entity);
	}
	
	@Override
	public Collection<Long> update(Collection<Employee> entities) throws FunctionalException {
		return updateService.update(entities);
	}
	
	@Override
	public Collection<Employee> updateAndReturn(Collection<Employee> entities) throws FunctionalException {
		return updateService.updateAndReturn(entities);
	}

	@Override
	public void delete(Long id) throws FunctionalException {
		deleteService.delete(id);
	}
	
	@Override
	public void deleteIfPresent(Long id) {
		deleteService.deleteIfPresent(id);
	}

	@Override
	public void deleteMany(Collection<Long> ids) throws FunctionalException {
		deleteService.deleteMany(ids);
	}

	@Override
	public void deleteManyIfPresent(Collection<Long> ids) {
		deleteService.deleteManyIfPresent(ids);
	}

	@Override
	public Employee execute(Employee employee) throws FunctionalException, TechnicalException {
		return createService.saveAndReturn(employee);
	}
	
}
