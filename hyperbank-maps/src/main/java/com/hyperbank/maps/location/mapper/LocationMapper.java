package com.hyperbank.maps.location.mapper;

import java.util.Collection;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.hyperbank.maps.city.entity.City;
import com.hyperbank.maps.city.service.CityService;
import com.hyperbank.maps.location.dto.LocationDto;
import com.hyperbank.maps.location.entity.Location;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.mapstruct.BaseMapperToEntityAndToDTO;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class LocationMapper implements BaseMapperToEntityAndToDTO<Location, LocationDto> {

	@Autowired
	private CityService cityService;

	@Override
	@Named("toEntity")
	@Mapping(source = "cityId", target = "city", qualifiedByName = "getCityById")
	public abstract Location toEntity(LocationDto dto);

	@Override
	@IterableMapping(qualifiedByName = "toEntity")
	public abstract Collection<Location> toEntities(Collection<LocationDto> dtoList);

	@Override
	@Mapping(source = "cityId", target = "city", qualifiedByName = "getCityById")
	public abstract void updateEntityFromDto(@MappingTarget Location entity, LocationDto dto);

	@Override
	@Named("toDto")
	@Mapping(source = "city.id", target = "cityId")
	public abstract LocationDto toDto(Location entity);

	@Override
	@IterableMapping(qualifiedByName = "toDto")
	public abstract Collection<LocationDto> toDtos(Collection<Location> entities);

	@Named("getCityById")
	protected City getCityById(Integer id) throws FunctionalException {
		return cityService.findById(id);
	}

}
