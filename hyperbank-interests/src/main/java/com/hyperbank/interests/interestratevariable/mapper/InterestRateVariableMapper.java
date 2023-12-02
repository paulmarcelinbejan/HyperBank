package com.hyperbank.interests.interestratevariable.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.hyperbank.interests.interestratevariable.dto.InterestRateVariableResponse;
import com.hyperbank.interests.interestratevariable.dto.InterestRateVariableSaveRequest;
import com.hyperbank.interests.interestratevariable.dto.InterestRateVariableUpdateRequest;
import com.hyperbank.interests.interestratevariable.entity.InterestRateVariable;
import com.hyperbank.interests.interestratevariable.service.InterestRateVariableService;
import com.hyperbank.interests.interestratevariablehistory.entity.InterestRateVariableHistory;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.service.helper.mapping.MapperFromEntityToResponse;
import io.github.paulmarcelinbejan.toolbox.service.helper.mapping.MapperFromSaveRequestToEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class InterestRateVariableMapper implements MapperFromSaveRequestToEntity<InterestRateVariable, InterestRateVariableSaveRequest>, MapperFromEntityToResponse<InterestRateVariable, InterestRateVariableResponse> {
	
	@Autowired
	private InterestRateVariableService interestRateVariableService;
	
	@Override
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "interestRate", ignore = true)
	@Mapping(target = "history", ignore = true)
	@Named("fromSaveRequestToEntity")
	public abstract InterestRateVariable fromSaveRequestToEntity(InterestRateVariableSaveRequest saveRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToEntity")
	public abstract List<InterestRateVariable> fromSaveRequestsToEntities(Collection<InterestRateVariableSaveRequest> saveRequests);

	@Named("fromUpdateRequestToHistoryEntity")
	public InterestRateVariableHistory fromUpdateRequestToHistoryEntity(InterestRateVariableUpdateRequest updateRequest) throws FunctionalException {
		InterestRateVariable toUpdate = interestRateVariableService.findById(updateRequest.getId());
		return fromUpdateRequestToHistoryEntity(updateRequest, toUpdate);
	}

	@IterableMapping(qualifiedByName = "fromUpdateRequestToHistoryEntity")
	public abstract List<InterestRateVariableHistory> fromUpdateRequestsToHistoryEntities(Collection<InterestRateVariableUpdateRequest> updateRequests);

	@Override
	@Named("toResponse")
	public abstract InterestRateVariableResponse toResponse(InterestRateVariable entity);

	@Override
	@IterableMapping(qualifiedByName = "toResponse")
	public abstract List<InterestRateVariableResponse> toResponses(Collection<InterestRateVariable> entities);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "interestRateVariable", source = "interestRateVariable")
	protected abstract InterestRateVariableHistory fromUpdateRequestToHistoryEntity(InterestRateVariableUpdateRequest updateRequest, InterestRateVariable interestRateVariable);
	
}