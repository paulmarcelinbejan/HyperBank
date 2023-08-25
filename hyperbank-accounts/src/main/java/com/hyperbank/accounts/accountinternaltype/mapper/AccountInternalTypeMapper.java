package com.hyperbank.accounts.accountinternaltype.mapper;

import java.util.Collection;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import com.hyperbank.accounts.accountinternaltype.dto.AccountInternalTypeResponse;
import com.hyperbank.accounts.accountinternaltype.dto.AccountInternalTypeSaveRequest;
import com.hyperbank.accounts.accountinternaltype.dto.AccountInternalTypeUpdateRequest;
import com.hyperbank.accounts.accountinternaltype.entity.AccountInternalType;
import com.paulmarcelinbejan.toolbox.utils.mapping.BaseMapperToEntityAndToResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class AccountInternalTypeMapper implements BaseMapperToEntityAndToResponse<AccountInternalType, AccountInternalTypeSaveRequest, AccountInternalTypeUpdateRequest, AccountInternalTypeResponse> {

	@Override
	@Named("fromSaveRequestToEntity")
	@Mapping(target = "id", ignore = true)
	public abstract AccountInternalType fromSaveRequestToEntity(AccountInternalTypeSaveRequest saveRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToEntity")
	public abstract Collection<AccountInternalType> fromSaveRequestsToEntities(Collection<AccountInternalTypeSaveRequest> saveRequests);

	@Override
	@Named("fromUpdateRequestToEntity")
	public abstract AccountInternalType fromUpdateRequestToEntity(AccountInternalTypeUpdateRequest updateRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToEntity")
	public abstract Collection<AccountInternalType> fromUpdateRequestsToEntities(Collection<AccountInternalTypeUpdateRequest> updateRequests);

	@Override
	@Mapping(target = "id", ignore = true)
	public abstract void updateEntity(@MappingTarget AccountInternalType toUpdate, AccountInternalType newValue);

	@Override
	@Named("toResponse")
	public abstract AccountInternalTypeResponse toResponse(AccountInternalType entity);

	@Override
	@IterableMapping(qualifiedByName = "toResponse")
	public abstract Collection<AccountInternalTypeResponse> toResponses(Collection<AccountInternalType> entities);
	
}