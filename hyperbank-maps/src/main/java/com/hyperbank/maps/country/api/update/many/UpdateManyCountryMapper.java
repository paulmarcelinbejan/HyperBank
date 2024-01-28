package com.hyperbank.maps.country.api.update.many;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.maps.country.api.update.one.UpdateOneCountryMapper;
import com.hyperbank.maps.country.dto.CountryUpdateRequest;
import com.hyperbank.maps.country.entity.Country;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.input.MapperInput;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

@Mapper(config = HyperBankMapperConfig.class, 
		uses = { UpdateOneCountryMapper.class } )
public interface UpdateManyCountryMapper extends 
	MapperInput<List<CountryUpdateRequest>, List<Country>> {
	
	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToDomain")
	List<Country> toDomain(List<CountryUpdateRequest> request) throws FunctionalException, TechnicalException;
	
}