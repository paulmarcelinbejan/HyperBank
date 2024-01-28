package com.hyperbank.maps.city.api.update.many;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.maps.city.api.update.one.UpdateOneCityMapper;
import com.hyperbank.maps.city.dto.CityUpdateRequest;
import com.hyperbank.maps.city.entity.City;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.input.MapperInput;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

@Mapper(config = HyperBankMapperConfig.class, 
		uses = { UpdateOneCityMapper.class } )
public interface UpdateManyCityMapper extends 
	MapperInput<List<CityUpdateRequest>, List<City>> {
	
	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToDomain")
	List<City> toDomain(List<CityUpdateRequest> request) throws FunctionalException, TechnicalException;
	
}