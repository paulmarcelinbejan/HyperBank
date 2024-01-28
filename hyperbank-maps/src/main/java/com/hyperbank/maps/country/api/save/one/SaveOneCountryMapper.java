package com.hyperbank.maps.country.api.save.one;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.maps.continent.api.find.one.FindOneContinentService;
import com.hyperbank.maps.continent.entity.Continent;
import com.hyperbank.maps.country.dto.CountrySaveRequest;
import com.hyperbank.maps.country.entity.Country;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.input.MapperInput;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;

@Mapper(config = HyperBankMapperConfig.class)
public abstract class SaveOneCountryMapper implements 
	MapperInput<CountrySaveRequest, Country> {
	
	@Autowired
	private FindOneContinentService findOneContinentService;
	
	@Override
	@Named("fromSaveRequestToDomain")
	@Mapping(target = "id", ignore = true)
	@Mapping(source = "continentId", target = "continent", qualifiedByName = "getContinentById")
	public abstract Country toDomain(CountrySaveRequest request);
	
	@Named("getContinentById")
	protected Continent getContinentById(Integer id) throws FunctionalException {
		return findOneContinentService.execute(id);
	}
	
}