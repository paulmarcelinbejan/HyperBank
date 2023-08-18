package com.hyperbank.accounts.customerindividual.mapper;

import java.util.Collection;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import com.hyperbank.accounts.customerindividual.dto.CustomerIndividualDto;
import com.hyperbank.accounts.customerindividual.entity.CustomerIndividual;
import com.paulmarcelinbejan.toolbox.mapstruct.BaseMapperToEntityAndToDTO;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class CustomerIndividualMapper implements BaseMapperToEntityAndToDTO<CustomerIndividual, CustomerIndividualDto> {

	@Override
	@Named("toEntity")
	public abstract CustomerIndividual toEntity(CustomerIndividualDto dto);

	@Override
	@IterableMapping(qualifiedByName = "toEntity")
	public abstract Collection<CustomerIndividual> toEntities(Collection<CustomerIndividualDto> dtos);

	@Override
	@Named("toDto")
	public abstract CustomerIndividualDto toDto(CustomerIndividual entity);

	@Override
	@IterableMapping(qualifiedByName = "toDto")
	public abstract Collection<CustomerIndividualDto> toDtos(Collection<CustomerIndividual> entities);

	@Override
	@Mapping(target = "id", ignore = true)
	public abstract void updateEntity(@MappingTarget CustomerIndividual toUpdate, CustomerIndividual newValue);

}