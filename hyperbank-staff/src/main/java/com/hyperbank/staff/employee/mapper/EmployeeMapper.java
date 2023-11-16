package com.hyperbank.staff.employee.mapper;

import java.util.Collection;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.hyperbank.staff.employee.dto.EmployeeUpdateRequest;
import com.hyperbank.staff.employee.entity.Employee;
import com.paulmarcelinbejan.architecture.sniper.mapper.input.MapperInput;
import com.paulmarcelinbejan.architecture.sniper.mapper.output.MapperOutput;
import com.paulmarcelinbejan.toolbox.utils.mapping.FullMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class EmployeeMapper implements 
	FullMapper<Employee, EmployeeSaveRequest, EmployeeUpdateRequest, EmployeeResponse>, 
	MapperInput<EmployeeSaveRequest, Employee>,
	MapperOutput<Employee, EmployeeResponse> {

	@Override
	@Named("fromSaveRequestToEntity")
	@Mapping(target = "id", ignore = true)
	public abstract Employee fromSaveRequestToEntity(EmployeeSaveRequest saveRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToEntity")
	public abstract Collection<Employee> fromSaveRequestsToEntities(Collection<EmployeeSaveRequest> saveRequests);

	@Override
	@Named("fromUpdateRequestToEntity")
	@Mapping(target = "id", ignore = true)
	public abstract Employee fromUpdateRequestToEntity(EmployeeUpdateRequest updateRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToEntity")
	public abstract Collection<Employee> fromUpdateRequestsToEntities(Collection<EmployeeUpdateRequest> updateRequests);

	@Override
	@Mapping(target = "id", ignore = true)
	public abstract void updateEntity(@MappingTarget Employee toUpdate, Employee newValue);

	@Override
	@Named("toResponse")
	public abstract EmployeeResponse toResponse(Employee entity);

	@Override
	@IterableMapping(qualifiedByName = "toResponse")
	public abstract Collection<EmployeeResponse> toResponses(Collection<Employee> entities);

	@Override
	@Named("toDomain")
	public Employee toDomain(EmployeeSaveRequest request) {
		return fromSaveRequestToEntity(request);
	}
	
}