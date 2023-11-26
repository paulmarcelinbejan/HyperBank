package com.hyperbank.staff.employee.mapper;

import java.util.Collection;
import java.util.List;

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
import com.paulmarcelinbejan.toolbox.service.helper.mapping.FullMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class EmployeeMapper implements 
	FullMapper<Employee, EmployeeSaveRequest, EmployeeUpdateRequest, EmployeeResponse> {

	@Override
	@Named("fromSaveRequestToEntity")
	@Mapping(target = "id", ignore = true)
	public abstract Employee fromSaveRequestToEntity(EmployeeSaveRequest saveRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToEntity")
	public abstract List<Employee> fromSaveRequestsToEntities(Collection<EmployeeSaveRequest> saveRequests);

	@Override
	@Named("fromUpdateRequestToEntity")
	@Mapping(target = "id", ignore = true)
	public abstract Employee fromUpdateRequestToEntity(EmployeeUpdateRequest updateRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToEntity")
	public abstract List<Employee> fromUpdateRequestsToEntities(Collection<EmployeeUpdateRequest> updateRequests);

	@Override
	@Mapping(target = "id", ignore = true)
	public abstract void updateEntity(@MappingTarget Employee toUpdate, Employee newValue);

	@Override
	@Named("toResponse")
	public abstract EmployeeResponse toResponse(Employee entity);

	@Override
	@IterableMapping(qualifiedByName = "toResponse")
	public abstract List<EmployeeResponse> toResponses(Collection<Employee> entities);
	
}