package com.hyperbank.staff.employee.api.find.many;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.staff.employee.api.find.one.EmployeeFindOneMapper;
import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.sniper.mapper.output.MapperOutput;

@Mapper(config = HyperBankMapperConfig.class,
		uses = { EmployeeFindOneMapper.class })
public interface EmployeeFindManyMapper extends 
	MapperOutput<List<Employee>, List<EmployeeResponse>> {
	
	@Override
	@IterableMapping(qualifiedByName = "fromDomainToResponse")
	List<EmployeeResponse> toResponse(List<Employee> entity);
	
}