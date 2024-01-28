package com.hyperbank.maps.location.api.update.many;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.maps.location.api.update.one.UpdateOneLocationMapper;
import com.hyperbank.maps.location.dto.LocationUpdateRequest;
import com.hyperbank.maps.location.entity.Location;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.input.MapperInput;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

@Mapper(config = HyperBankMapperConfig.class, 
		uses = { UpdateOneLocationMapper.class } )
public interface UpdateManyLocationMapper extends 
	MapperInput<List<LocationUpdateRequest>, List<Location>> {
	
	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToDomain")
	List<Location> toDomain(List<LocationUpdateRequest> request) throws FunctionalException, TechnicalException;
	
}