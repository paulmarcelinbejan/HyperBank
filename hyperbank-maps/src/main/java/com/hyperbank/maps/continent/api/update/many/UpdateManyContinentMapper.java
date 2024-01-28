package com.hyperbank.maps.continent.api.update.many;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.maps.continent.api.update.one.UpdateOneContinentMapper;
import com.hyperbank.maps.continent.dto.ContinentUpdateRequest;
import com.hyperbank.maps.continent.entity.Continent;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.input.MapperInput;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

@Mapper(config = HyperBankMapperConfig.class, 
		uses = { UpdateOneContinentMapper.class } )
public interface UpdateManyContinentMapper extends 
	MapperInput<List<ContinentUpdateRequest>, List<Continent>> {
	
	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToDomain")
	List<Continent> toDomain(List<ContinentUpdateRequest> request) throws FunctionalException, TechnicalException;
	
}