package com.hyperbank.staff.employee.api.update.one;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.staff.employee.api.find.one.FindOneEmployeeService;
import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeUpdateRequest;
import com.hyperbank.staff.employee.entity.Employee;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.input.MapperInput;
import io.github.paulmarcelinbejan.coordinator.architecture.mapper.output.MapperOutput;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

@Mapper(config = HyperBankMapperConfig.class)
public abstract class UpdateOneEmployeeMapper implements 
	MapperInput<EmployeeUpdateRequest, Employee>,
	MapperOutput<Employee, EmployeeResponse> {
	
	@Autowired
	private FindOneEmployeeService findOneEmployeeService;
	
	@Override
	@Named("fromUpdateRequestToDomain")
	public Employee toDomain(EmployeeUpdateRequest request) throws FunctionalException, TechnicalException {
		Employee employee = findOneEmployeeService.execute(request.getId());
		return updateEmployee(request, employee);
	}
	
	@Mapping(target = "id", ignore = true)
	public abstract Employee updateEmployee(EmployeeUpdateRequest request, @MappingTarget Employee employee);
	
}