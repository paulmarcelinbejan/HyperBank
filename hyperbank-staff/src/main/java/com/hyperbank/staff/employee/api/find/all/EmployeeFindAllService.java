package com.hyperbank.staff.employee.api.find.all;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.sniper.service.ServiceOutputAware;

@Service
public interface EmployeeFindAllService extends ServiceOutputAware<List<Employee>> {

}
