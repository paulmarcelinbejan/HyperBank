package com.hyperbank.maps.continent.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.maps.continent.dto.ContinentResponse;
import com.hyperbank.maps.continent.entity.Continent;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.output.MapperOutput;

@Mapper(config = HyperBankMapperConfig.class)
public interface EntityToDtoContinentMapper extends 
	MapperOutput<Continent, ContinentResponse> {
	
	@Override
	@Named("fromEntityToDto")
	ContinentResponse toResponse(Continent entity);
	
}