package com.hyperbank.accounts.accountinternaltype.mapper;

import java.util.Collection;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import com.hyperbank.accounts.accountinternaltype.dto.AccountInternalTypeDto;
import com.hyperbank.accounts.accountinternaltype.entity.AccountInternalType;
import com.paulmarcelinbejan.toolbox.mapstruct.BaseMapperToEntityAndToDTO;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class AccountInternalTypeMapper implements BaseMapperToEntityAndToDTO<AccountInternalType, AccountInternalTypeDto> {

	@Override
	@Named("toEntity")
	public abstract AccountInternalType toEntity(AccountInternalTypeDto dto);

	@Override
	@IterableMapping(qualifiedByName = "toEntity")
	public abstract Collection<AccountInternalType> toEntities(Collection<AccountInternalTypeDto> dtos);

	@Override
	@Named("toDto")
	public abstract AccountInternalTypeDto toDto(AccountInternalType entity);

	@Override
	@IterableMapping(qualifiedByName = "toDto")
	public abstract Collection<AccountInternalTypeDto> toDtos(Collection<AccountInternalType> entities);

	@Override
	@Mapping(target = "id", ignore = true)
	public abstract void updateEntity(@MappingTarget AccountInternalType toUpdate, AccountInternalType newValue);

}