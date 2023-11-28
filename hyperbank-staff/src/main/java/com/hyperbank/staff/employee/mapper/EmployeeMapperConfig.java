package com.hyperbank.staff.employee.mapper;

import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.hyperbank.staff.employee.entity.Employee;

@MapperConfig(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeMapperConfig {

	@Mapping(target = "id", ignore = true)
	Employee fromSaveRequestToEntity(EmployeeSaveRequest saveRequest);

	EmployeeResponse fromEntityToResponse(Employee entity);
	
}