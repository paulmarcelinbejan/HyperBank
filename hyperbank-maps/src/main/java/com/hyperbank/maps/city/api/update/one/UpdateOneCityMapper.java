package com.hyperbank.maps.city.api.update.one;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.maps.city.api.find.one.FindOneCityService;
import com.hyperbank.maps.city.dto.CityUpdateRequest;
import com.hyperbank.maps.city.entity.City;
import com.hyperbank.maps.country.api.find.one.FindOneCountryService;
import com.hyperbank.maps.country.entity.Country;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.input.MapperInput;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

@Mapper(config = HyperBankMapperConfig.class)
public abstract class UpdateOneCityMapper implements 
	MapperInput<CityUpdateRequest, City> {
	
	@Autowired
	private FindOneCityService findOneCityService;
	
	@Autowired
	private FindOneCountryService findOneCountryService;
	
	@Override
	@Named("fromUpdateRequestToDomain")
	public City toDomain(CityUpdateRequest request) throws FunctionalException, TechnicalException {
		City city = findOneCityService.execute(request.getId());
		return updateCity(request, city);
	}
	
	@Mapping(target = "id", ignore = true)
	@Mapping(source = "countryId", target = "country", qualifiedByName = "getCountryById")
	public abstract City updateCity(CityUpdateRequest request, @MappingTarget City city);
	
	@Named("getCountryById")
	protected Country getCountryById(Integer id) throws FunctionalException {
		return findOneCountryService.execute(id);
	}
	
}