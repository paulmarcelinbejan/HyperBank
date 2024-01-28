package com.hyperbank.maps.location.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.maps.location.dto.LocationResponse;
import com.hyperbank.maps.location.entity.Location;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.output.MapperOutput;

@Mapper(config = HyperBankMapperConfig.class)
public interface EntityToDtoLocationMapper extends 
	MapperOutput<Location, LocationResponse> {
	
	@Override
	@Named("fromEntityToDto")
	@Mapping(source = "city.id", target = "cityId")
	LocationResponse toResponse(Location entity);
	
}