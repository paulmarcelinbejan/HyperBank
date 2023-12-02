package com.hyperbank.interests.interestratefixed.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import com.hyperbank.interests.interestratefixed.dto.InterestRateFixedResponse;
import com.hyperbank.interests.interestratefixed.dto.InterestRateFixedSaveRequest;
import com.hyperbank.interests.interestratefixed.entity.InterestRateFixed;

import io.github.paulmarcelinbejan.toolbox.service.helper.mapping.MapperFromSaveRequestToEntityAndFromEntityToResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class InterestRateFixedMapper implements MapperFromSaveRequestToEntityAndFromEntityToResponse<InterestRateFixed, InterestRateFixedSaveRequest, InterestRateFixedResponse> {

	@Override
	@Named("fromSaveRequestToEntity")
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "interestRate", ignore = true)
	public abstract InterestRateFixed fromSaveRequestToEntity(InterestRateFixedSaveRequest saveRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToEntity")
	public abstract List<InterestRateFixed> fromSaveRequestsToEntities(Collection<InterestRateFixedSaveRequest> saveRequests);

	@Override
	@Named("toResponse")
	public abstract InterestRateFixedResponse toResponse(InterestRateFixed entity);

	@Override
	@IterableMapping(qualifiedByName = "toResponse")
	public abstract List<InterestRateFixedResponse> toResponses(Collection<InterestRateFixed> entities);

}