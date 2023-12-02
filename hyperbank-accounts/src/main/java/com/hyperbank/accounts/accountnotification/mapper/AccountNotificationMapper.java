package com.hyperbank.accounts.accountnotification.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import com.hyperbank.accounts.accountnotification.dto.AccountNotificationResponse;
import com.hyperbank.accounts.accountnotification.dto.AccountNotificationSaveRequest;
import com.hyperbank.accounts.accountnotification.entity.AccountNotification;

import io.github.paulmarcelinbejan.toolbox.service.helper.mapping.MapperFromSaveRequestToEntityAndFromEntityToResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class AccountNotificationMapper implements MapperFromSaveRequestToEntityAndFromEntityToResponse<AccountNotification, AccountNotificationSaveRequest, AccountNotificationResponse> {

	@Override
	@Named("fromSaveRequestToEntity")
	@Mapping(target = "id", ignore = true)
	public abstract AccountNotification fromSaveRequestToEntity(AccountNotificationSaveRequest saveRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToEntity")
	public abstract List<AccountNotification> fromSaveRequestsToEntities(Collection<AccountNotificationSaveRequest> saveRequests);

	@Override
	@Named("toResponse")
	public abstract AccountNotificationResponse toResponse(AccountNotification entity);

	@Override
	@IterableMapping(qualifiedByName = "toResponse")
	public abstract List<AccountNotificationResponse> toResponses(Collection<AccountNotification> entities);

}