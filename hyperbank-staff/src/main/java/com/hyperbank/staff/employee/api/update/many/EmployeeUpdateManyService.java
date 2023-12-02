package com.hyperbank.staff.employee.api.update.many;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.sniper.service.ServiceInputOutputAware;

@Service
public interface EmployeeUpdateManyService extends ServiceInputOutputAware<List<Employee>, List<Employee>> {

}
