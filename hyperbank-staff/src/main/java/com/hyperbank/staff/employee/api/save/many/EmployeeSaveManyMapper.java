package com.hyperbank.staff.employee.api.save.many;

import java.util.List;

import org.mapstruct.IterableMapping;
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
	MapperInput<List<EmployeeSaveRequest>, List<Employee>>,
	MapperOutput<List<Employee>, List<EmployeeResponse>> {
	
	@Override
	@IterableMapping(qualifiedByName = "toSingleDomain")
	public abstract List<Employee> toDomain(List<EmployeeSaveRequest> request);
	
	@Named("toSingleDomain")
	@Mapping(target = "id", ignore = true)
	protected abstract Employee toSingleDomain(EmployeeSaveRequest request);
	
	@Override
	@IterableMapping(qualifiedByName = "toSingleResponse")
	public abstract List<EmployeeResponse> toResponse(List<Employee> entity);
	
	@Named("toSingleResponse")
	protected abstract EmployeeResponse toSingleResponse(Employee entity);
	
}