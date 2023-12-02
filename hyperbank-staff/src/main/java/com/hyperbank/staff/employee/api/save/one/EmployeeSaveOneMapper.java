package com.hyperbank.staff.employee.api.save.one;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.coordinator.mapper.input.MapperInput;
import com.paulmarcelinbejan.architecture.coordinator.mapper.output.MapperOutput;

@Mapper(config = HyperBankMapperConfig.class)
public interface EmployeeSaveOneMapper extends 
	MapperInput<EmployeeSaveRequest, Employee>,
	MapperOutput<Employee, EmployeeResponse> {
	
	@Override
	@Named("fromSaveRequestToDomain")
	@Mapping(target = "id", ignore = true)
	Employee toDomain(EmployeeSaveRequest request);
	
	@Override
	EmployeeResponse toResponse(Employee entity);
	
}