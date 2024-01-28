package com.hyperbank.maps.location.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.maps.location.dto.LocationResponse;
import com.hyperbank.maps.location.entity.Location;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.output.MapperOutput;

@Mapper(config = HyperBankMapperConfig.class, 
		uses = { EntityToDtoLocationMapper.class })
public interface EntitiesToDtosLocationMapper 
	extends MapperOutput<List<Location>, List<LocationResponse>> {

	@Override
	@IterableMapping(qualifiedByName = "fromEntityToDto")
	List<LocationResponse> toResponse(List<Location> entities);

}