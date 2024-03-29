package com.hyperbank.accounts.accountinternal.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.hyperbank.accounts.account.entity.Account;
import com.hyperbank.accounts.account.service.AccountService;
import com.hyperbank.accounts.accountinternal.dto.AccountInternalResponse;
import com.hyperbank.accounts.accountinternal.dto.AccountInternalSaveRequest;
import com.hyperbank.accounts.accountinternal.dto.AccountInternalUpdateRequest;
import com.hyperbank.accounts.accountinternal.entity.AccountInternal;
import com.hyperbank.accounts.accountinternaltype.entity.AccountInternalType;
import com.hyperbank.accounts.accountinternaltype.service.AccountInternalTypeService;
import com.hyperbank.accounts.customer.entity.Customer;
import com.hyperbank.accounts.customer.service.CustomerService;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.service.helper.mapping.FullMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class AccountInternalMapper implements FullMapper<AccountInternal, AccountInternalSaveRequest, AccountInternalUpdateRequest, AccountInternalResponse> {
	
	@Autowired
	private AccountInternalTypeService accountInternalTypeService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CustomerService customerService;
	
	@Override
	@Named("fromSaveRequestToEntity")
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "account", ignore = true)
	@Mapping(source = "accountInternalTypeId", target = "accountInternalType", qualifiedByName = "getAccountInternalTypeById")
	@Mapping(source = "customerId", target = "customer", qualifiedByName = "getCustomerById")
	public abstract AccountInternal fromSaveRequestToEntity(AccountInternalSaveRequest saveRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToEntity")
	public abstract List<AccountInternal> fromSaveRequestsToEntities(Collection<AccountInternalSaveRequest> saveRequests);

	@Override
	@Named("fromUpdateRequestToEntity")
	@Mapping(source = "id", target = "account", qualifiedByName = "getAccountReferenceById")
	@Mapping(source = "accountInternalTypeId", target = "accountInternalType", qualifiedByName = "getAccountInternalTypeById")
	@Mapping(source = "customerId", target = "customer", qualifiedByName = "getCustomerById")
	public abstract AccountInternal fromUpdateRequestToEntity(AccountInternalUpdateRequest updateRequest);
	
	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToEntity")
	public abstract List<AccountInternal> fromUpdateRequestsToEntities(Collection<AccountInternalUpdateRequest> updateRequests);
	
	@Override
	@Mapping(target = "id", ignore = true)
	public abstract void updateEntity(@MappingTarget AccountInternal toUpdate, AccountInternal newValue);

	@Override
	@Named("toResponse")
	@Mapping(source = "accountInternalType.id", target = "accountInternalTypeId")
	@Mapping(source = "customer.id", target = "customerId")
	public abstract AccountInternalResponse toResponse(AccountInternal entity);
	
	@Override
	@IterableMapping(qualifiedByName = "toResponse")
	public abstract List<AccountInternalResponse> toResponses(Collection<AccountInternal> entities);
	
	@Named("getAccountReferenceById")
	protected Account getAccountReferenceById(Long id) {
		return accountService.getReferenceById(id);
	}
	
	@Named("getAccountInternalTypeById")
	protected AccountInternalType getAccountInternalTypeById(Integer id) throws FunctionalException {
		return accountInternalTypeService.findById(id);
	}
	
	@Named("getCustomerById")
	protected Customer getCustomerById(Long id) throws FunctionalException {
		return customerService.findById(id);
	}
	
}