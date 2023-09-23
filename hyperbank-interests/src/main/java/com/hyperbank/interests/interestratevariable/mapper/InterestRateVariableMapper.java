package com.hyperbank.interests.interestratevariable.mapper;

import java.util.Collection;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.hyperbank.interests.interestratevariable.dto.InterestRateVariableResponse;
import com.hyperbank.interests.interestratevariable.dto.InterestRateVariableSaveRequest;
import com.hyperbank.interests.interestratevariable.dto.InterestRateVariableUpdateRequest;
import com.hyperbank.interests.interestratevariable.entity.InterestRateVariable;
import com.hyperbank.interests.interestratevariable.service.InterestRateVariableService;
import com.hyperbank.interests.interestratevariablehistory.entity.InterestRateVariableHistory;
import com.hyperbank.interests.interestratevariablehistory.service.InterestRateVariableHistoryService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.utils.mapping.FullMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class InterestRateVariableMapper implements FullMapper<InterestRateVariable, InterestRateVariableSaveRequest, InterestRateVariableUpdateRequest, InterestRateVariableResponse> {
	
	@Autowired
	private InterestRateVariableService interestRateVariableService;
	
	@Autowired
	private InterestRateVariableHistoryService interestRateVariableHistoryService;
	
	@Override
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "interestRate", ignore = true)
	@Mapping(target = "interestRateVariableHistoryList", ignore = true)
	@Named("fromSaveRequestToEntity")
	public abstract InterestRateVariable fromSaveRequestToEntity(InterestRateVariableSaveRequest saveRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToEntity")
	public abstract Collection<InterestRateVariable> fromSaveRequestsToEntities(Collection<InterestRateVariableSaveRequest> saveRequests);

	@Override
	@Named("fromUpdateRequestToEntity")
	public InterestRateVariable fromUpdateRequestToEntity(InterestRateVariableUpdateRequest updateRequest) throws FunctionalException {
		InterestRateVariable toUpdate = interestRateVariableService.findById(updateRequest.getId());
		InterestRateVariableHistory interestRateVariableHistory = interestRateVariableHistoryService.saveAndReturn(fromUpdateRequestToHistoryEntity(updateRequest, toUpdate));
		toUpdate.addInterestRateHistory(interestRateVariableHistory);
		return toUpdate;
	}

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

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "interestRateVariable", source = "interestRateVariable")
	protected abstract InterestRateVariableHistory fromUpdateRequestToHistoryEntity(InterestRateVariableUpdateRequest updateRequest, InterestRateVariable interestRateVariable);
	
}