package com.hyperbank.maps.country.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.maps.country.dto.CountryResponse;
import com.hyperbank.maps.country.entity.Country;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.output.MapperOutput;

@Mapper(config = HyperBankMapperConfig.class)
public interface EntityToDtoCountryMapper extends 
	MapperOutput<Country, CountryResponse> {
	
	@Override
	@Named("fromEntityToDto")
	@Mapping(source = "continent.id", target = "continentId")
	CountryResponse toResponse(Country entity);
	
}