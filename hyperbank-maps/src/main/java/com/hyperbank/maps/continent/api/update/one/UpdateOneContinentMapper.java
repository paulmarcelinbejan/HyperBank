package com.hyperbank.maps.continent.api.update.one;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.maps.continent.api.find.one.FindOneContinentService;
import com.hyperbank.maps.continent.dto.ContinentUpdateRequest;
import com.hyperbank.maps.continent.entity.Continent;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.input.MapperInput;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

@Mapper(config = HyperBankMapperConfig.class)
public abstract class UpdateOneContinentMapper implements 
	MapperInput<ContinentUpdateRequest, Continent> {
	
	@Autowired
	private FindOneContinentService findOneContinentService;
	
	@Override
	@Named("fromUpdateRequestToDomain")
	public Continent toDomain(ContinentUpdateRequest request) throws FunctionalException, TechnicalException {
		Continent continent = findOneContinentService.execute(request.getId());
		return updateContinent(request, continent);
	}
	
	@Mapping(target = "id", ignore = true)
	public abstract Continent updateContinent(ContinentUpdateRequest request, @MappingTarget Continent continent);
	
}