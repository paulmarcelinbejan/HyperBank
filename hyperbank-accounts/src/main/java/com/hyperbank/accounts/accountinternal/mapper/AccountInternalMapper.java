package com.hyperbank.accounts.accountinternal.mapper;

import java.util.Collection;

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
import com.hyperbank.commons.currency.entity.Currency;
import com.hyperbank.commons.currency.service.CurrencyService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.utils.mapping.BaseMapperToEntityAndToResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class AccountInternalMapper implements BaseMapperToEntityAndToResponse<AccountInternal, AccountInternalSaveRequest, AccountInternalUpdateRequest, AccountInternalResponse> {
	
	@Autowired
	private AccountInternalTypeService accountInternalTypeService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CurrencyService currencyService;
	
	@Autowired
	private CustomerService customerService;
	
	@Override
	@Named("fromSaveRequestToEntity")
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "account", ignore = true)
	@Mapping(source = "accountInternalTypeId", target = "accountInternalType", qualifiedByName = "getAccountInternalTypeById")
	@Mapping(source = "currencyId", target = "currency", qualifiedByName = "getCurrencyById")
	@Mapping(source = "customerId", target = "customer", qualifiedByName = "getCustomerById")
	public abstract AccountInternal fromSaveRequestToEntity(AccountInternalSaveRequest saveRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToEntity")
	public abstract Collection<AccountInternal> fromSaveRequestsToEntities(Collection<AccountInternalSaveRequest> saveRequests);

	@Override
	@Named("fromUpdateRequestToEntity")
	@Mapping(source = "id", target = "account", qualifiedByName = "getAccountReferenceById")
	@Mapping(source = "accountInternalTypeId", target = "accountInternalType", qualifiedByName = "getAccountInternalTypeById")
	@Mapping(source = "currencyId", target = "currency", qualifiedByName = "getCurrencyById")
	@Mapping(source = "customerId", target = "customer", qualifiedByName = "getCustomerById")
	public abstract AccountInternal fromUpdateRequestToEntity(AccountInternalUpdateRequest updateRequest);
	
	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToEntity")
	public abstract Collection<AccountInternal> fromUpdateRequestsToEntities(Collection<AccountInternalUpdateRequest> updateRequests);
	
	@Override
	@Mapping(target = "id", ignore = true)
	public abstract void updateEntity(@MappingTarget AccountInternal toUpdate, AccountInternal newValue);

	@Override
	@Named("toResponse")
	@Mapping(source = "accountInternalType.id", target = "accountInternalTypeId")
	@Mapping(source = "currency.id", target = "currencyId")
	@Mapping(source = "customer.id", target = "customerId")
	public abstract AccountInternalResponse toResponse(AccountInternal entity);
	
	@Override
	@IterableMapping(qualifiedByName = "toResponse")
	public abstract Collection<AccountInternalResponse> toResponses(Collection<AccountInternal> entities);
	
	@Named("getAccountReferenceById")
	protected Account getAccountReferenceById(Long id) {
		return accountService.getReferenceById(id);
	}
	
	@Named("getAccountInternalTypeById")
	protected AccountInternalType getAccountInternalTypeById(Integer id) throws FunctionalException {
		return accountInternalTypeService.findById(id);
	}
	
	@Named("getCurrencyById")
	protected Currency getCurrencyById(Integer id) throws FunctionalException {
		return currencyService.findById(id);
	}
	
	@Named("getCustomerById")
	protected Customer getCustomerById(Long id) throws FunctionalException {
		return customerService.findById(id);
	}
	
}