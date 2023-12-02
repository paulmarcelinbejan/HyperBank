package com.hyperbank.staff.employee.api.find.one;

import org.springframework.stereotype.Service;

import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.sniper.service.ServiceInputOutputAware;

@Service
public interface EmployeeFindOneService extends ServiceInputOutputAware<Long, Employee> {

}
