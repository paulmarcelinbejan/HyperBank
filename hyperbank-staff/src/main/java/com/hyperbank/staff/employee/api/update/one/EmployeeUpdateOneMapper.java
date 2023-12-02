package com.hyperbank.staff.employee.api.update.one;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.staff.employee.api.find.one.EmployeeFindOneService;
import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeUpdateRequest;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.sniper.mapper.input.MapperInput;
import com.paulmarcelinbejan.architecture.sniper.mapper.output.MapperOutput;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

@Mapper(config = HyperBankMapperConfig.class)
public abstract class EmployeeUpdateOneMapper implements 
	MapperInput<EmployeeUpdateRequest, Employee>,
	MapperOutput<Employee, EmployeeResponse> {
	
	@Autowired
	private EmployeeFindOneService employeeFindOneService;
	
	@Override
	@Named("fromUpdateRequestToDomain")
	public Employee toDomain(EmployeeUpdateRequest request) throws FunctionalException, TechnicalException {
		Employee employee = employeeFindOneService.execute(request.getId());
		return updateEmployee(request, employee);
	}
	
	@Mapping(target = "id", ignore = true)
	public abstract Employee updateEmployee(EmployeeUpdateRequest request, @MappingTarget Employee employee);
	
}