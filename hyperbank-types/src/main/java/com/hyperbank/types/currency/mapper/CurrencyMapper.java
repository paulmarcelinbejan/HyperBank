package com.hyperbank.types.currency.mapper;

import java.util.Collection;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import com.hyperbank.types.currency.dto.CurrencyResponse;
import com.hyperbank.types.currency.dto.CurrencySaveRequest;
import com.hyperbank.types.currency.dto.CurrencyUpdateRequest;
import com.hyperbank.types.currency.entity.Currency;
import com.paulmarcelinbejan.toolbox.utils.mapping.FullMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class CurrencyMapper implements FullMapper<Currency, CurrencySaveRequest, CurrencyUpdateRequest, CurrencyResponse> {

	@Override
	@Named("fromSaveRequestToEntity")
	@Mapping(target = "id", ignore = true)
	public abstract Currency fromSaveRequestToEntity(CurrencySaveRequest saveRequest);
	
	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToEntity")
	public abstract Collection<Currency> fromSaveRequestsToEntities(Collection<CurrencySaveRequest> saveRequests);
	
	@Override
	@Named("fromUpdateRequestToEntity")
	public abstract Currency fromUpdateRequestToEntity(CurrencyUpdateRequest updateRequest);
	
	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToEntity")
	public abstract Collection<Currency> fromUpdateRequestsToEntities(Collection<CurrencyUpdateRequest> updateRequests);

	@Override
	@Mapping(target = "id", ignore = true)
	public abstract void updateEntity(@MappingTarget Currency toUpdate, Currency newValue);
	
	@Override
	@Named("toResponse")
	public abstract CurrencyResponse toResponse(Currency entity);

	@Override
	@IterableMapping(qualifiedByName = "toResponse")
	public abstract Collection<CurrencyResponse> toResponses(Collection<Currency> entities);
	
}