package com.hyperbank.accounts.customerindividual.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.hyperbank.accounts.customer.entity.Customer;
import com.hyperbank.accounts.customer.service.CustomerService;
import com.hyperbank.accounts.customerindividual.dto.CustomerIndividualResponse;
import com.hyperbank.accounts.customerindividual.dto.CustomerIndividualSaveRequest;
import com.hyperbank.accounts.customerindividual.dto.CustomerIndividualUpdateRequest;
import com.hyperbank.accounts.customerindividual.entity.CustomerIndividual;

import io.github.paulmarcelinbejan.toolbox.service.helper.mapping.FullMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class CustomerIndividualMapper implements FullMapper<CustomerIndividual, CustomerIndividualSaveRequest, CustomerIndividualUpdateRequest, CustomerIndividualResponse> {

	@Autowired
	private CustomerService customerService;
	
	@Override
	@Named("fromSaveRequestToEntity")
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "customer", ignore = true)
	public abstract CustomerIndividual fromSaveRequestToEntity(CustomerIndividualSaveRequest saveRequest);
	
	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToEntity")
	public abstract List<CustomerIndividual> fromSaveRequestsToEntities(Collection<CustomerIndividualSaveRequest> saveRequests);

	@Override
	@Named("fromUpdateRequestToEntity")
	@Mapping(source = "id", target = "customer", qualifiedByName = "getCustomerReferenceById")
	public abstract CustomerIndividual fromUpdateRequestToEntity(CustomerIndividualUpdateRequest updateRequest);
	
	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToEntity")
	public abstract List<CustomerIndividual> fromUpdateRequestsToEntities(Collection<CustomerIndividualUpdateRequest> updateRequests);
	
	@Override
	@Mapping(target = "id", ignore = true)
	public abstract void updateEntity(@MappingTarget CustomerIndividual toUpdate, CustomerIndividual newValue);

	@Override
	@Named("toResponse")
	public abstract CustomerIndividualResponse toResponse(CustomerIndividual entity);

	@Override
	@IterableMapping(qualifiedByName = "toResponse")
	public abstract List<CustomerIndividualResponse> toResponses(Collection<CustomerIndividual> entities);
	
	@Named("getCustomerReferenceById")
	protected Customer getCustomerReferenceById(Long id) {
		return customerService.getReferenceById(id);
	}
	
}