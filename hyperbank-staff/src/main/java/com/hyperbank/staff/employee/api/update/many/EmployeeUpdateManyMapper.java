package com.hyperbank.staff.employee.api.update.many;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.staff.employee.api.find.one.EmployeeFindOneMapper;
import com.hyperbank.staff.employee.api.update.one.EmployeeUpdateOneMapper;
import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeUpdateRequest;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.coordinator.mapper.input.MapperInput;
import com.paulmarcelinbejan.architecture.coordinator.mapper.output.MapperOutput;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

@Mapper(config = HyperBankMapperConfig.class, 
		uses = { EmployeeFindOneMapper.class, EmployeeUpdateOneMapper.class } )
public interface EmployeeUpdateManyMapper extends 
	MapperInput<List<EmployeeUpdateRequest>, List<Employee>>,
	MapperOutput<List<Employee>, List<EmployeeResponse>> {
	
	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToDomain")
	List<Employee> toDomain(List<EmployeeUpdateRequest> request) throws FunctionalException, TechnicalException;
	
	@Override
	List<EmployeeResponse> toResponse(List<Employee> entities);
	
}