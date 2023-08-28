package com.hyperbank.accounts.depositaccountdetails.mapper;

import java.util.Collection;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import com.hyperbank.accounts.depositaccountdetails.dto.DepositAccountResponse;
import com.hyperbank.accounts.depositaccountdetails.entity.DepositAccountDetails;
import com.paulmarcelinbejan.toolbox.utils.mapping.MapperToResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class DepositAccountDetailsMapper implements MapperToResponse<DepositAccountDetails, DepositAccountResponse> {

	@Override
	@Named("toResponse")
	@Mapping(target = ".", source = "accountInternal")
	@Mapping(target = "accountInternalTypeId", source = "accountInternal.accountInternalType.id")
	@Mapping(target = "customerId", source = "accountInternal.customer.id")
	public abstract DepositAccountResponse toResponse(DepositAccountDetails entity);

	@Override
	@IterableMapping(qualifiedByName = "toResponse")
	public abstract Collection<DepositAccountResponse> toResponses(Collection<DepositAccountDetails> entities);

}