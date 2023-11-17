package com.hyperbank.staff.employee.sniper;

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
public class SniperEmployeeSave extends BaseSniper<EmployeeSaveRequest, Employee, Employee, EmployeeResponse>{

	public SniperEmployeeSave(
			Validator<EmployeeSaveRequest> validator,
			MapperInput<EmployeeSaveRequest, Employee> mapperInput, 
			Service<Employee, Employee> service,
			MapperOutput<Employee, EmployeeResponse> mapperOutput) {
		super(validator, mapperInput, service, mapperOutput);
	}
	
}
