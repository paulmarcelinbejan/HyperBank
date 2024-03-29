package com.hyperbank.interests.interestratevariablehistory.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import com.hyperbank.interests.interestratevariablehistory.entity.InterestRateVariableHistory;

import io.github.paulmarcelinbejan.toolbox.service.helper.mapping.MapperUpdateEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class InterestRateVariableHistoryMapper implements MapperUpdateEntity<InterestRateVariableHistory> {

	@Override
	@Mapping(target = "id", ignore = true)
	public abstract void updateEntity(@MappingTarget InterestRateVariableHistory toUpdate, InterestRateVariableHistory newValue);
	
}
