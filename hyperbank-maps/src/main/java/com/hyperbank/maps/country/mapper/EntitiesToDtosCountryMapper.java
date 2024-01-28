package com.hyperbank.maps.country.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.maps.continent.entity.Continent;
import com.hyperbank.maps.country.dto.CountryResponse;
import com.hyperbank.maps.country.entity.Country;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.output.MapperOutput;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;

@Mapper(config = HyperBankMapperConfig.class, 
		uses = { EntityToDtoCountryMapper.class })
public interface EntitiesToDtosCountryMapper 
	extends MapperOutput<List<Country>, List<CountryResponse>> {

	@Override
	@IterableMapping(qualifiedByName = "fromEntityToDto")
	List<CountryResponse> toResponse(List<Country> entities);


	
	
}