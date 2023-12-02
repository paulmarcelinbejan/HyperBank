package com.hyperbank.staff.employee.api.find.many;

import java.util.List;

import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.sniper.service.ServiceInputOutputAware;

public interface EmployeeFindManyService extends ServiceInputOutputAware<List<Long>, List<Employee>> {

}
