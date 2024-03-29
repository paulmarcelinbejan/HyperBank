package com.hyperbank.accounts.depositaccountdetails.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import com.hyperbank.accounts.depositaccountdetails.dto.DepositAccountResponse;
import com.hyperbank.accounts.depositaccountdetails.entity.DepositAccountDetails;

import io.github.paulmarcelinbejan.toolbox.service.helper.mapping.MapperFromEntityToResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class DepositAccountDetailsMapper implements MapperFromEntityToResponse<DepositAccountDetails, DepositAccountResponse> {

	@Override
	@Named("toResponse")
	@Mapping(target = ".", source = "accountInternal")
	@Mapping(target = "accountInternalTypeId", source = "accountInternal.accountInternalType.id")
	@Mapping(target = "customerId", source = "accountInternal.customer.id")
	public abstract DepositAccountResponse toResponse(DepositAccountDetails entity);

	@Override
	@IterableMapping(qualifiedByName = "toResponse")
	public abstract List<DepositAccountResponse> toResponses(Collection<DepositAccountDetails> entities);

}