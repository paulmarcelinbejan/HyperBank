package com.hyperbank.maps.city.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.maps.city.dto.CityResponse;
import com.hyperbank.maps.city.entity.City;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.output.MapperOutput;

@Mapper(config = HyperBankMapperConfig.class, 
		uses = { EntityToDtoCityMapper.class })
public interface EntitiesToDtosCityMapper 
	extends MapperOutput<List<City>, List<CityResponse>> {

	@Override
	@IterableMapping(qualifiedByName = "fromEntityToDto")
	List<CityResponse> toResponse(List<City> entities);

}