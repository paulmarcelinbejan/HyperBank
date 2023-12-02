package com.hyperbank.staff.employee.api.find.many;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.sniper.service.ServiceInputOutputAware;

@Service
public interface EmployeeFindManyService extends ServiceInputOutputAware<List<Long>, List<Employee>> {

}
