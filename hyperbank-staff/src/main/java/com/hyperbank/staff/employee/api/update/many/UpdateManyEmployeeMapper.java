package com.hyperbank.staff.employee.api.update.many;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.staff.employee.api.find.one.FindOneEmployeeMapper;
import com.hyperbank.staff.employee.api.update.one.UpdateOneEmployeeMapper;
import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeUpdateRequest;
import com.hyperbank.staff.employee.entity.Employee;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.input.MapperInput;
import io.github.paulmarcelinbejan.coordinator.architecture.mapper.output.MapperOutput;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

@Mapper(config = HyperBankMapperConfig.class, 
		uses = { FindOneEmployeeMapper.class, UpdateOneEmployeeMapper.class } )
public interface UpdateManyEmployeeMapper extends 
	MapperInput<List<EmployeeUpdateRequest>, List<Employee>>,
	MapperOutput<List<Employee>, List<EmployeeResponse>> {
	
	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToDomain")
	List<Employee> toDomain(List<EmployeeUpdateRequest> request) throws FunctionalException, TechnicalException;
	
	@Override
	List<EmployeeResponse> toResponse(List<Employee> entities);
	
}