package com.hyperbank.commons.currency.mapper;

import java.util.Collection;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import com.hyperbank.commons.currency.dto.CurrencyDto;
import com.hyperbank.commons.currency.entity.Currency;
import com.paulmarcelinbejan.toolbox.mapstruct.BaseMapperToEntityAndToDTO;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class CurrencyMapper implements BaseMapperToEntityAndToDTO<Currency, CurrencyDto> {

	@Override
	@Named("toEntity")
	public abstract Currency toEntity(CurrencyDto dto);

	@Override
	@IterableMapping(qualifiedByName = "toEntity")
	public abstract Collection<Currency> toEntities(Collection<CurrencyDto> dtos);

	@Override
	@Named("toDto")
	public abstract CurrencyDto toDto(Currency entity);

	@Override
	@IterableMapping(qualifiedByName = "toDto")
	public abstract Collection<CurrencyDto> toDtos(Collection<Currency> entities);

	@Override
	@Mapping(target = "id", ignore = true)
	public abstract void updateEntity(@MappingTarget Currency toUpdate, Currency newValue);

}