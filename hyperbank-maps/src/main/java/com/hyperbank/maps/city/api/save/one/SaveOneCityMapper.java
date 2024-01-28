package com.hyperbank.maps.city.api.save.one;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.maps.city.dto.CitySaveRequest;
import com.hyperbank.maps.city.entity.City;
import com.hyperbank.maps.country.api.find.one.FindOneCountryService;
import com.hyperbank.maps.country.entity.Country;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.input.MapperInput;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;

@Mapper(config = HyperBankMapperConfig.class)
public abstract class SaveOneCityMapper implements 
	MapperInput<CitySaveRequest, City> {
	
	@Autowired
	private FindOneCountryService findOneCountryService;
	
	@Override
	@Named("fromSaveRequestToDomain")
	@Mapping(target = "id", ignore = true)
	@Mapping(source = "countryId", target = "country", qualifiedByName = "getCountryById")
	public abstract City toDomain(CitySaveRequest request);
	
	@Named("getCountryById")
	protected Country getCountryById(Integer id) throws FunctionalException {
		return findOneCountryService.execute(id);
	}
	
}