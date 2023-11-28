package com.hyperbank.staff.employee.api.save.one;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.hyperbank.staff.employee.entity.Employee;
import com.hyperbank.staff.employee.mapper.EmployeeMapperConfig;
import com.paulmarcelinbejan.architecture.sniper.mapper.input.MapperInput;
import com.paulmarcelinbejan.architecture.sniper.mapper.output.MapperOutput;

@Mapper(config = EmployeeMapperConfig.class)
public interface EmployeeSaveOneMapper extends 
	MapperInput<EmployeeSaveRequest, Employee>,
	MapperOutput<Employee, EmployeeResponse> {
	
	@Override
	@Named("fromRequestToDomain")
	@InheritConfiguration
	Employee toDomain(EmployeeSaveRequest request);
	
	@Override
	@InheritConfiguration
	EmployeeResponse toResponse(Employee entity);
	
}