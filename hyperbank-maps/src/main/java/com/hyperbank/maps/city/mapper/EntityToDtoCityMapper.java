package com.hyperbank.maps.city.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.maps.city.dto.CityResponse;
import com.hyperbank.maps.city.entity.City;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.output.MapperOutput;

@Mapper(config = HyperBankMapperConfig.class)
public interface EntityToDtoCityMapper extends 
	MapperOutput<City, CityResponse> {
	
	@Override
	@Named("fromEntityToDto")
	@Mapping(source = "country.id", target = "countryId")
	CityResponse toResponse(City entity);
	
}