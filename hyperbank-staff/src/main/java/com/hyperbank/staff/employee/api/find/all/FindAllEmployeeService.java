package com.hyperbank.staff.employee.api.find.all;

import java.util.List;

import com.hyperbank.staff.employee.entity.Employee;

import io.github.paulmarcelinbejan.coordinator.architecture.service.ServiceOutputAware;

public interface FindAllEmployeeService extends ServiceOutputAware<List<Employee>> {

}
