package com.hyperbank.maps.country.api.update.one;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.maps.continent.api.find.one.FindOneContinentService;
import com.hyperbank.maps.continent.entity.Continent;
import com.hyperbank.maps.country.api.find.one.FindOneCountryService;
import com.hyperbank.maps.country.dto.CountryUpdateRequest;
import com.hyperbank.maps.country.entity.Country;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.input.MapperInput;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

@Mapper(config = HyperBankMapperConfig.class)
public abstract class UpdateOneCountryMapper implements 
	MapperInput<CountryUpdateRequest, Country> {
	
	@Autowired
	private FindOneCountryService findOneCountryService;
	
	@Autowired
	private FindOneContinentService findOneContinentService;
	
	@Override
	@Named("fromUpdateRequestToDomain")
	public Country toDomain(CountryUpdateRequest request) throws FunctionalException, TechnicalException {
		Country country = findOneCountryService.execute(request.getId());
		return updateCountry(request, country);
	}
	
	@Mapping(target = "id", ignore = true)
	@Mapping(source = "continentId", target = "continent", qualifiedByName = "getContinentById")
	public abstract Country updateCountry(CountryUpdateRequest request, @MappingTarget Country country);
	
	@Named("getContinentById")
	protected Continent getContinentById(Integer id) throws FunctionalException {
		return findOneContinentService.execute(id);
	}
	
}