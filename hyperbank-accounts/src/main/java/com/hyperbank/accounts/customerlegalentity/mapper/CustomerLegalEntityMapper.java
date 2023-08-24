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
import com.hyperbank.accounts.customerlegalentity.dto.CustomerLegalEntityDto;
import com.hyperbank.accounts.customerlegalentity.entity.CustomerLegalEntity;
import com.paulmarcelinbejan.toolbox.mapstruct.BaseMapperToEntityAndToDTO;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class CustomerLegalEntityMapper implements BaseMapperToEntityAndToDTO<CustomerLegalEntity, CustomerLegalEntityDto> {

	@Autowired
	private CustomerService customerService;
	
	@Override
	@Named("toEntity")
	@Mapping(source = "id", target = "customer", qualifiedByName = "getCustomerReferenceById")
	public abstract CustomerLegalEntity toEntity(CustomerLegalEntityDto dto);

	@Override
	@IterableMapping(qualifiedByName = "toEntity")
	public abstract Collection<CustomerLegalEntity> toEntities(Collection<CustomerLegalEntityDto> dtos);

	@Override
	@Named("toDto")
	public abstract CustomerLegalEntityDto toDto(CustomerLegalEntity entity);

	@Override
	@IterableMapping(qualifiedByName = "toDto")
	public abstract Collection<CustomerLegalEntityDto> toDtos(Collection<CustomerLegalEntity> entities);

	@Override
	@Mapping(target = "id", ignore = true)
	public abstract void updateEntity(@MappingTarget CustomerLegalEntity toUpdate, CustomerLegalEntity newValue);

	@Named("getCustomerReferenceById")
	protected Customer getCustomerReferenceById(Long id) {
		return customerService.getReferenceById(id);
	}
	
}