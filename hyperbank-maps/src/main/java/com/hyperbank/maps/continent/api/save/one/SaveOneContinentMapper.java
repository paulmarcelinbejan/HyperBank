package com.hyperbank.maps.continent.api.save.one;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.maps.continent.dto.ContinentSaveRequest;
import com.hyperbank.maps.continent.entity.Continent;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.input.MapperInput;

@Mapper(config = HyperBankMapperConfig.class)
public interface SaveOneContinentMapper extends 
	MapperInput<ContinentSaveRequest, Continent> {
	
	@Override
	@Named("fromSaveRequestToDomain")
	@Mapping(target = "id", ignore = true)
	Continent toDomain(ContinentSaveRequest request);
	
}