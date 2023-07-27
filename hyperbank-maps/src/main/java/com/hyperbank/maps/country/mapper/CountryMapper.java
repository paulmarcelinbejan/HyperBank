package com.hyperbank.maps.country.mapper;

import java.util.Collection;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.hyperbank.maps.continent.entity.Continent;
import com.hyperbank.maps.continent.service.ContinentService;
import com.hyperbank.maps.country.dto.CountryDto;
import com.hyperbank.maps.country.entity.Country;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.mapstruct.BaseMapperToEntityAndToDTO;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class CountryMapper implements BaseMapperToEntityAndToDTO<Country, CountryDto> {

	@Autowired
	private ContinentService continentService;

	@Override
	@Named("toEntity")
	@Mapping(source = "continentId", target = "continent", qualifiedByName = "getContinentById")
	public abstract Country toEntity(CountryDto dto);

	@Override
	@IterableMapping(qualifiedByName = "toEntity")
	public abstract Collection<Country> toEntities(Collection<CountryDto> dtoList);

	@Override
	@Mapping(source = "continentId", target = "continent", qualifiedByName = "getContinentById")
	public abstract void updateEntityFromDto(@MappingTarget Country entity, CountryDto dto);

	@Override
	@Named("toDto")
	@Mapping(source = "continent.id", target = "continentId")
	public abstract CountryDto toDto(Country entity);

	@Override
	@IterableMapping(qualifiedByName = "toDto")
	public abstract Collection<CountryDto> toDtos(Collection<Country> entities);

	@Named("getContinentById")
	protected Continent getContinentById(Integer id) throws FunctionalException {
		return continentService.findById(id);
	}

}
