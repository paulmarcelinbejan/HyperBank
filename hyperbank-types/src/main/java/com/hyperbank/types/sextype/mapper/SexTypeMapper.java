package com.hyperbank.types.sextype.mapper;

import java.util.Collection;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import com.hyperbank.types.sextype.dto.SexTypeResponse;
import com.hyperbank.types.sextype.dto.SexTypeSaveRequest;
import com.hyperbank.types.sextype.dto.SexTypeUpdateRequest;
import com.hyperbank.types.sextype.entity.SexType;
import com.paulmarcelinbejan.toolbox.utils.mapping.FullMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class SexTypeMapper implements FullMapper<SexType, SexTypeSaveRequest, SexTypeUpdateRequest, SexTypeResponse> {

	@Override
	@Named("fromSaveRequestToEntity")
	@Mapping(target = "id", ignore = true)
	public abstract SexType fromSaveRequestToEntity(SexTypeSaveRequest saveRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToEntity")
	public abstract Collection<SexType> fromSaveRequestsToEntities(Collection<SexTypeSaveRequest> saveRequests);

	@Override
	@Named("fromUpdateRequestToEntity")
	public abstract SexType fromUpdateRequestToEntity(SexTypeUpdateRequest updateRequest);
	
	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToEntity")
	public abstract Collection<SexType> fromUpdateRequestsToEntities(Collection<SexTypeUpdateRequest> updateRequests);
	
	@Override
	@Mapping(target = "id", ignore = true)
	public abstract void updateEntity(@MappingTarget SexType toUpdate, SexType newValue);
	
	@Override
	@Named("toResponse")
	public abstract SexTypeResponse toResponse(SexType entity);

	@Override
	@IterableMapping(qualifiedByName = "toResponse")
	public abstract Collection<SexTypeResponse> toResponses(Collection<SexType> entities);

}