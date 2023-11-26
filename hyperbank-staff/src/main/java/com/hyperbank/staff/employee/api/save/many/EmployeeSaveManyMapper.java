package com.hyperbank.staff.employee.api.save.many;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.sniper.mapper.input.MapperInput;
import com.paulmarcelinbejan.architecture.sniper.mapper.output.MapperOutput;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class EmployeeSaveManyMapper implements 
	MapperInput<EmployeeSaveRequest, Employee>,
	MapperOutput<Employee, EmployeeResponse> {
	
	@Override
	@Named("toDomain")
	@Mapping(target = "id", ignore = true)
	public abstract Employee toDomain(EmployeeSaveRequest request);
	
	@Override
	@Named("toResponse")
	public abstract EmployeeResponse toResponse(Employee entity);
	
}