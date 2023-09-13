package com.hyperbank.interests.interestratevariable.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import com.hyperbank.interests.interestratevariable.dto.InterestRateVariableResponse;
import com.hyperbank.interests.interestratevariable.dto.InterestRateVariableSaveRequest;
import com.hyperbank.interests.interestratevariable.dto.InterestRateVariableUpdateRequest;
import com.hyperbank.interests.interestratevariable.entity.InterestRateVariable;
import com.hyperbank.interests.interestratevariablehistory.entity.InterestRateVariableHistory;
import com.paulmarcelinbejan.toolbox.utils.mapping.FullMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class InterestRateVariableMapper implements FullMapper<InterestRateVariable, InterestRateVariableSaveRequest, InterestRateVariableUpdateRequest, InterestRateVariableResponse> {

	@Override
	@Named("fromSaveRequestToEntity")
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "interestRateVariableHistoryList", qualifiedByName = "mapSaveRequestToHistoryList")
	public abstract InterestRateVariable fromSaveRequestToEntity(InterestRateVariableSaveRequest saveRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToEntity")
	public abstract Collection<InterestRateVariable> fromSaveRequestsToEntities(Collection<InterestRateVariableSaveRequest> saveRequests);

	@Override
	@Named("fromUpdateRequestToEntity")
	@Mapping(target = "id", ignore = true)
	public abstract InterestRateVariable fromUpdateRequestToEntity(InterestRateVariableUpdateRequest updateRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToEntity")
	public abstract Collection<InterestRateVariable> fromUpdateRequestsToEntities(Collection<InterestRateVariableUpdateRequest> updateRequests);

	@Override
	@Mapping(target = "id", ignore = true)
	public abstract void updateEntity(@MappingTarget InterestRateVariable toUpdate, InterestRateVariable newValue);

	@Override
	@Named("toResponse")
	public abstract InterestRateVariableResponse toResponse(InterestRateVariable entity);

	@Override
	@IterableMapping(qualifiedByName = "toResponse")
	public abstract Collection<InterestRateVariableResponse> toResponses(Collection<InterestRateVariable> entities);

	protected abstract InterestRateVariableHistory fromSaveRequestToHistoryEntity(InterestRateVariableSaveRequest saveRequest);
	
	@Named("mapSaveRequestToHistoryList")
	protected List<InterestRateVariableHistory> mapSaveRequestToHistoryList(InterestRateVariableSaveRequest saveRequest){
		return List.of(fromSaveRequestToHistoryEntity(saveRequest));
	}
}