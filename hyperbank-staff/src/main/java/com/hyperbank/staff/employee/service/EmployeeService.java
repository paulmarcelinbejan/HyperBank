package com.hyperbank.staff.employee.service;

import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.sniper.service.Service;
import com.paulmarcelinbejan.toolbox.web.service.aggregate.CrudService;

public interface EmployeeService extends CrudService<Long, Employee>, Service<Employee, Employee> {

}
