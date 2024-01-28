package com.hyperbank.maps.continent.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.maps.continent.dto.ContinentResponse;
import com.hyperbank.maps.continent.entity.Continent;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.output.MapperOutput;

@Mapper(config = HyperBankMapperConfig.class, 
		uses = { EntityToDtoContinentMapper.class })
public interface EntitiesToDtosContinentMapper 
	extends MapperOutput<List<Continent>, List<ContinentResponse>> {

	@Override
	@IterableMapping(qualifiedByName = "fromEntityToDto")
	List<ContinentResponse> toResponse(List<Continent> entities);

}