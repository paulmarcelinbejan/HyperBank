package com.hyperbank.maps.continent.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import com.hyperbank.maps.continent.dto.ContinentDto;
import com.hyperbank.maps.continent.entity.Continent;
import com.paulmarcelinbejan.toolbox.mapstruct.BaseMapperToEntityAndToDTO;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContinentMapper extends BaseMapperToEntityAndToDTO<Continent, ContinentDto> {

	@Override
	@Mapping(target = "id", ignore = true)
	void updateEntity(@MappingTarget Continent toUpdate, Continent newValue);

}
