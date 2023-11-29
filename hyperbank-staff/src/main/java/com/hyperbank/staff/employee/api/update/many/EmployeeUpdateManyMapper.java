package com.hyperbank.staff.employee.api.update.many;

import java.util.List;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import com.hyperbank.staff.employee.api.find.one.EmployeeFindOneMapper;
import com.hyperbank.staff.employee.api.update.one.EmployeeUpdateOneMapper;
import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeUpdateRequest;
import com.hyperbank.staff.employee.entity.Employee;
import com.hyperbank.staff.employee.mapper.EmployeeMapperConfig;
import com.paulmarcelinbejan.architecture.sniper.mapper.input.MapperInput;
import com.paulmarcelinbejan.architecture.sniper.mapper.output.MapperOutput;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

@Mapper(config = EmployeeMapperConfig.class, 
		uses = { EmployeeFindOneMapper.class, EmployeeUpdateOneMapper.class } )
public interface EmployeeUpdateManyMapper extends 
	MapperInput<List<EmployeeUpdateRequest>, List<Employee>>,
	MapperOutput<List<Employee>, List<EmployeeResponse>> {
	
	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToDomain")
	List<Employee> toDomain(List<EmployeeUpdateRequest> request) throws FunctionalException, TechnicalException;
	
	@Override
	@InheritConfiguration
	List<EmployeeResponse> toResponse(List<Employee> entities);
	
}