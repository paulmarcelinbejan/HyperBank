package com.hyperbank.commons.sextype.mapper;

import java.util.Collection;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import com.hyperbank.commons.sextype.dto.SexTypeDto;
import com.hyperbank.commons.sextype.entity.SexType;
import com.paulmarcelinbejan.toolbox.mapstruct.BaseMapperToEntityAndToDTO;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class SexTypeMapper implements BaseMapperToEntityAndToDTO<SexType, SexTypeDto> {

	@Override
	@Named("toEntity")
	public abstract SexType toEntity(SexTypeDto dto);

	@Override
	@IterableMapping(qualifiedByName = "toEntity")
	public abstract Collection<SexType> toEntities(Collection<SexTypeDto> dtos);

	@Override
	@Named("toDto")
	public abstract SexTypeDto toDto(SexType entity);

	@Override
	@IterableMapping(qualifiedByName = "toDto")
	public abstract Collection<SexTypeDto> toDtos(Collection<SexType> entities);

	@Override
	@Mapping(target = "id", ignore = true)
	public abstract void updateEntity(@MappingTarget SexType toUpdate, SexType newValue);

}