package com.hyperbank.interests.interestratetype.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import com.hyperbank.interests.interestratetype.dto.InterestRateTypeResponse;
import com.hyperbank.interests.interestratetype.dto.InterestRateTypeSaveRequest;
import com.hyperbank.interests.interestratetype.dto.InterestRateTypeUpdateRequest;
import com.hyperbank.interests.interestratetype.entity.InterestRateType;

import io.github.paulmarcelinbejan.toolbox.service.helper.mapping.FullMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class InterestRateTypeMapper implements FullMapper<InterestRateType, InterestRateTypeSaveRequest, InterestRateTypeUpdateRequest, InterestRateTypeResponse> {

	@Override
	@Named("fromSaveRequestToEntity")
	@Mapping(target = "id", ignore = true)
	public abstract InterestRateType fromSaveRequestToEntity(InterestRateTypeSaveRequest saveRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToEntity")
	public abstract List<InterestRateType> fromSaveRequestsToEntities(Collection<InterestRateTypeSaveRequest> saveRequests);

	@Override
	@Named("fromUpdateRequestToEntity")
	@Mapping(target = "id", ignore = true)
	public abstract InterestRateType fromUpdateRequestToEntity(InterestRateTypeUpdateRequest updateRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToEntity")
	public abstract List<InterestRateType> fromUpdateRequestsToEntities(Collection<InterestRateTypeUpdateRequest> updateRequests);

	@Override
	@Mapping(target = "id", ignore = true)
	public abstract void updateEntity(@MappingTarget InterestRateType toUpdate, InterestRateType newValue);

	@Override
	@Named("toResponse")
	public abstract InterestRateTypeResponse toResponse(InterestRateType entity);

	@Override
	@IterableMapping(qualifiedByName = "toResponse")
	public abstract List<InterestRateTypeResponse> toResponses(Collection<InterestRateType> entities);

}