package com.hyperbank.accounts.accountinternaltype.mapper;

import java.util.Collection;
import java.util.List;

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

import io.github.paulmarcelinbejan.toolbox.service.helper.mapping.FullMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class AccountInternalTypeMapper implements FullMapper<AccountInternalType, AccountInternalTypeSaveRequest, AccountInternalTypeUpdateRequest, AccountInternalTypeResponse> {

	@Override
	@Named("fromSaveRequestToEntity")
	@Mapping(target = "id", ignore = true)
	public abstract AccountInternalType fromSaveRequestToEntity(AccountInternalTypeSaveRequest saveRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToEntity")
	public abstract List<AccountInternalType> fromSaveRequestsToEntities(Collection<AccountInternalTypeSaveRequest> saveRequests);

	@Override
	@Named("fromUpdateRequestToEntity")
	public abstract AccountInternalType fromUpdateRequestToEntity(AccountInternalTypeUpdateRequest updateRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToEntity")
	public abstract List<AccountInternalType> fromUpdateRequestsToEntities(Collection<AccountInternalTypeUpdateRequest> updateRequests);

	@Override
	@Mapping(target = "id", ignore = true)
	public abstract void updateEntity(@MappingTarget AccountInternalType toUpdate, AccountInternalType newValue);

	@Override
	@Named("toResponse")
	public abstract AccountInternalTypeResponse toResponse(AccountInternalType entity);

	@Override
	@IterableMapping(qualifiedByName = "toResponse")
	public abstract List<AccountInternalTypeResponse> toResponses(Collection<AccountInternalType> entities);
	
}