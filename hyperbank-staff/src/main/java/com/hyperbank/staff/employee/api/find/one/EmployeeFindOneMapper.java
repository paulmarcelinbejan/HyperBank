package com.hyperbank.staff.employee.api.find.one;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.entity.Employee;
import com.hyperbank.staff.employee.mapper.EmployeeMapperConfig;
import com.paulmarcelinbejan.architecture.sniper.mapper.input.MapperInput;
import com.paulmarcelinbejan.architecture.sniper.mapper.output.MapperOutput;

@Mapper(config = EmployeeMapperConfig.class)
public interface EmployeeFindOneMapper extends 
	MapperInput<Long, Long>,
	MapperOutput<Employee, EmployeeResponse> {
	
	@Override
	default Long toDomain(Long request) {
		return request;
	}
	
	@Override
	@Named("fromDomainToResponse")
	@InheritConfiguration
	EmployeeResponse toResponse(Employee entity);
	
}