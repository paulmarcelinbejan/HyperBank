package com.hyperbank.staff.employee.api.save.many;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.staff.employee.api.find.one.FindOneEmployeeMapper;
import com.hyperbank.staff.employee.api.save.one.SaveOneEmployeeMapper;
import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.hyperbank.staff.employee.entity.Employee;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.input.MapperInput;
import io.github.paulmarcelinbejan.coordinator.architecture.mapper.output.MapperOutput;

@Mapper(config = HyperBankMapperConfig.class,
		uses = { FindOneEmployeeMapper.class, SaveOneEmployeeMapper.class })
public interface SaveManyEmployeeMapper extends  
	MapperInput<List<EmployeeSaveRequest>, List<Employee>>,
	MapperOutput<List<Employee>, List<EmployeeResponse>> {
	
	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToDomain")
	List<Employee> toDomain(List<EmployeeSaveRequest> request);
	
	@Override
	@IterableMapping(qualifiedByName = "fromDomainToResponse")
	List<EmployeeResponse> toResponse(List<Employee> entity);
	
}