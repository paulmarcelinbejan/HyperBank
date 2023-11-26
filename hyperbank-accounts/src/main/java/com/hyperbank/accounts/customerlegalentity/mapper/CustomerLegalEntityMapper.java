package com.hyperbank.accounts.customerlegalentity.mapper;

import java.util.Collection;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.hyperbank.accounts.customer.entity.Customer;
import com.hyperbank.accounts.customer.service.CustomerService;
import com.hyperbank.accounts.customerlegalentity.dto.CustomerLegalEntityResponse;
import com.hyperbank.accounts.customerlegalentity.dto.CustomerLegalEntitySaveRequest;
import com.hyperbank.accounts.customerlegalentity.dto.CustomerLegalEntityUpdateRequest;
import com.hyperbank.accounts.customerlegalentity.entity.CustomerLegalEntity;
import com.paulmarcelinbejan.toolbox.service.helper.mapping.FullMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class CustomerLegalEntityMapper implements FullMapper<CustomerLegalEntity, CustomerLegalEntitySaveRequest, CustomerLegalEntityUpdateRequest, CustomerLegalEntityResponse> {

	@Autowired
	private CustomerService customerService;
	
	@Override
	@Named("fromSaveRequestToEntity")
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "customer", ignore = true)
	public abstract CustomerLegalEntity fromSaveRequestToEntity(CustomerLegalEntitySaveRequest saveRequest);
	
	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToEntity")
	public abstract Collection<CustomerLegalEntity> fromSaveRequestsToEntities(Collection<CustomerLegalEntitySaveRequest> saveRequests);

	@Override
	@Named("fromUpdateRequestToEntity")
	@Mapping(source = "id", target = "customer", qualifiedByName = "getCustomerReferenceById")
	public abstract CustomerLegalEntity fromUpdateRequestToEntity(CustomerLegalEntityUpdateRequest updateRequest);
	
	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToEntity")
	public abstract Collection<CustomerLegalEntity> fromUpdateRequestsToEntities(Collection<CustomerLegalEntityUpdateRequest> updateRequests);
	
	@Override
	@Mapping(target = "id", ignore = true)
	public abstract void updateEntity(@MappingTarget CustomerLegalEntity toUpdate, CustomerLegalEntity newValue);

	@Override
	@Named("toResponse")
	public abstract CustomerLegalEntityResponse toResponse(CustomerLegalEntity entity);

	@Override
	@IterableMapping(qualifiedByName = "toResponse")
	public abstract Collection<CustomerLegalEntityResponse> toResponses(Collection<CustomerLegalEntity> entities);
	
	@Named("getCustomerReferenceById")
	protected Customer getCustomerReferenceById(Long id) {
		return customerService.getReferenceById(id);
	}
	
}