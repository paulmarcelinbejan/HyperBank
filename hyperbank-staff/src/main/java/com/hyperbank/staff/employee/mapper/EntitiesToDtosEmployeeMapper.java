package com.hyperbank.staff.employee.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.entity.Employee;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.output.MapperOutput;

@Mapper(config = HyperBankMapperConfig.class, 
		uses = { EntityToDtoEmployeeMapper.class })
public interface EntitiesToDtosEmployeeMapper 
	extends MapperOutput<List<Employee>, List<EmployeeResponse>> {

	@Override
	@IterableMapping(qualifiedByName = "fromEntityToDto")
	List<EmployeeResponse> toResponse(List<Employee> entities);

}