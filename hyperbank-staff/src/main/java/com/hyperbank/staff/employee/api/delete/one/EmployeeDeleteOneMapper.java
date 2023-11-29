package com.hyperbank.staff.employee.api.delete.one;

import org.mapstruct.Mapper;

import com.hyperbank.staff.employee.mapper.EmployeeMapperConfig;
import com.paulmarcelinbejan.architecture.sniper.mapper.input.MapperInput;
import com.paulmarcelinbejan.architecture.sniper.mapper.output.MapperOutput;

@Mapper(config = EmployeeMapperConfig.class)
public interface EmployeeDeleteOneMapper extends 
	MapperInput<Long, Long>,
	MapperOutput<Void, Void> {
	
	@Override
	default Long toDomain(Long id) {
		return id;
	}
	
	@Override
	default Void toResponse(Void nothing) {
		return null;
	}
	
}