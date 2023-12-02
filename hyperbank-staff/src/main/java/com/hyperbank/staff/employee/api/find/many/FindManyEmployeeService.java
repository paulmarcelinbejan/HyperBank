package com.hyperbank.staff.employee.api.find.many;

import java.util.List;

import com.hyperbank.staff.employee.entity.Employee;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceInputOutputAware;

public interface FindManyEmployeeService extends ServiceInputOutputAware<List<Long>, List<Employee>> {

}
