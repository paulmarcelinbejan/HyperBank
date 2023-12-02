package com.hyperbank.staff.employee.api.update.many;

import java.util.List;

import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.coordinator.service.ServiceInputOutputAware;

public interface UpdateManyEmployeeService extends ServiceInputOutputAware<List<Employee>, List<Employee>> {

}
