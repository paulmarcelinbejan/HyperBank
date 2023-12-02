package com.hyperbank.staff.employee.api.save.many;

import java.util.List;

import com.hyperbank.staff.employee.entity.Employee;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;

public interface SaveManyEmployeeService extends ServiceInputOutputAware<List<Employee>, List<Employee>> {

}
