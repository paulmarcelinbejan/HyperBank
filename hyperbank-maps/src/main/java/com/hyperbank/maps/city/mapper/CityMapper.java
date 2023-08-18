package com.hyperbank.maps.city.mapper;

import java.util.Collection;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.hyperbank.maps.city.dto.CityDto;
import com.hyperbank.maps.city.entity.City;
import com.hyperbank.maps.country.entity.Country;
import com.hyperbank.maps.country.service.CountryService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.mapstruct.BaseMapperToEntityAndToDTO;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class CityMapper implements BaseMapperToEntityAndToDTO<City, CityDto> {

	@Autowired
	private CountryService countryService;

	@Override
	@Named("toEntity")
	@Mapping(source = "countryId", target = "country", qualifiedByName = "getCountryById")
	public abstract City toEntity(CityDto dto);

	@Override
	@IterableMapping(qualifiedByName = "toEntity")
	public abstract Collection<City> toEntities(Collection<CityDto> dtoList);

	@Override
	@Named("toDto")
	@Mapping(source = "country.id", target = "countryId")
	public abstract CityDto toDto(City entity);
	
	@Override
	@IterableMapping(qualifiedByName = "toDto")
	public abstract Collection<CityDto> toDtos(Collection<City> entities);

	@Override
	@Mapping(target = "id", ignore = true)
	public abstract void updateEntity(@MappingTarget City toUpdate, City newValue);
	
	@Named("getCountryById")
	protected Country getCountryById(Integer id) throws FunctionalException {
		return countryService.findById(id);
	}

}