package com.hyperbank.staff.employee.api.save.one;

import org.springframework.stereotype.Service;

import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.sniper.service.ServiceInputOutputAware;

@Service
public interface EmployeeSaveOneService extends ServiceInputOutputAware<Employee, Employee> {

}
