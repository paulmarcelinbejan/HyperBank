package com.hyperbank.staff.employee.api.find.many;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import com.hyperbank.staff.employee.api.find.one.EmployeeFindOneMapper;
import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.entity.Employee;
import com.hyperbank.staff.employee.mapper.EmployeeMapperConfig;
import com.paulmarcelinbejan.architecture.sniper.mapper.input.MapperInput;
import com.paulmarcelinbejan.architecture.sniper.mapper.output.MapperOutput;

@Mapper(config = EmployeeMapperConfig.class,
		uses = { EmployeeFindOneMapper.class })
public interface EmployeeFindManyMapper extends 
	MapperInput<List<Long>, List<Long>>,
	MapperOutput<List<Employee>, List<EmployeeResponse>> {
	
	@Override
	default List<Long> toDomain(List<Long> request) {
		return request;
	}
	
	@Override
	@IterableMapping(qualifiedByName = "fromDomainToResponse")
	List<EmployeeResponse> toResponse(List<Employee> entity);
	
}