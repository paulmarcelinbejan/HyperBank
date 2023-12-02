package com.hyperbank.staff.employee.api.find.one;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.coordinator.mapper.output.MapperOutput;

@Mapper(config = HyperBankMapperConfig.class)
public interface EmployeeFindOneMapper extends 
	MapperOutput<Employee, EmployeeResponse> {
	
	@Override
	@Named("fromDomainToResponse")
	EmployeeResponse toResponse(Employee entity);
	
}