package com.hyperbank.staff.employee.api.save.many;

import java.util.List;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.sniper.base.BaseSniper;
import com.paulmarcelinbejan.architecture.sniper.mapper.input.MapperInput;
import com.paulmarcelinbejan.architecture.sniper.mapper.output.MapperOutput;
import com.paulmarcelinbejan.architecture.sniper.service.Service;
import com.paulmarcelinbejan.architecture.sniper.stereotype.Sniper;
import com.paulmarcelinbejan.architecture.sniper.validator.Validator;

@Sniper
public class EmployeeSaveManySniper extends BaseSniper<List<EmployeeSaveRequest>, List<Employee>, List<Employee>, List<EmployeeResponse>> {

	public EmployeeSaveManySniper(
			Validator<List<EmployeeSaveRequest>> validator,
			MapperInput<List<EmployeeSaveRequest>, List<Employee>> mapperInput, 
			Service<List<Employee>, List<Employee>> service,
			MapperOutput<List<Employee>, List<EmployeeResponse>> mapperOutput) {
		super(validator, mapperInput, service, mapperOutput);
	}
	
}
