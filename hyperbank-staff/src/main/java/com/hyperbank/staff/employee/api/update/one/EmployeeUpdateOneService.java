package com.hyperbank.staff.employee.api.update.one;

import org.springframework.stereotype.Service;

import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.sniper.service.ServiceInputOutputAware;

@Service
public interface EmployeeUpdateOneService extends ServiceInputOutputAware<Employee, Employee> {

}
