package com.hyperbank.staff.employee.api.save.many;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import com.hyperbank.staff.employee.api.find.one.EmployeeFindOneMapper;
import com.hyperbank.staff.employee.api.save.one.EmployeeSaveOneMapper;
import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.hyperbank.staff.employee.entity.Employee;
import com.hyperbank.staff.employee.mapper.EmployeeMapperConfig;
import com.paulmarcelinbejan.architecture.sniper.mapper.input.MapperInput;
import com.paulmarcelinbejan.architecture.sniper.mapper.output.MapperOutput;

@Mapper(config = EmployeeMapperConfig.class,
		uses = { EmployeeFindOneMapper.class, EmployeeSaveOneMapper.class })
public interface EmployeeSaveManyMapper extends  
	MapperInput<List<EmployeeSaveRequest>, List<Employee>>,
	MapperOutput<List<Employee>, List<EmployeeResponse>> {
	
	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToDomain")
	List<Employee> toDomain(List<EmployeeSaveRequest> request);
	
	@Override
	@IterableMapping(qualifiedByName = "fromDomainToResponse")
	List<EmployeeResponse> toResponse(List<Employee> entity);
	
}