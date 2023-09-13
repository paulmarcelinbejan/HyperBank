package com.hyperbank.maps.city.mapper;

import java.util.Collection;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.hyperbank.maps.city.dto.CityResponse;
import com.hyperbank.maps.city.dto.CitySaveRequest;
import com.hyperbank.maps.city.dto.CityUpdateRequest;
import com.hyperbank.maps.city.entity.City;
import com.hyperbank.maps.country.entity.Country;
import com.hyperbank.maps.country.service.CountryService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.utils.mapping.FullMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class CityMapper implements FullMapper<City, CitySaveRequest, CityUpdateRequest, CityResponse> {

	@Autowired
	private CountryService countryService;

	@Override
	@Named("fromSaveRequestToEntity")
	@Mapping(target = "id", ignore = true)
	@Mapping(source = "countryId", target = "country", qualifiedByName = "getCountryById")
	public abstract City fromSaveRequestToEntity(CitySaveRequest saveRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToEntity")
	public abstract Collection<City> fromSaveRequestsToEntities(Collection<CitySaveRequest> saveRequests);

	@Override
	@Named("fromUpdateRequestToEntity")
	@Mapping(source = "countryId", target = "country", qualifiedByName = "getCountryById")
	public abstract City fromUpdateRequestToEntity(CityUpdateRequest updateRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToEntity")
	public abstract Collection<City> fromUpdateRequestsToEntities(Collection<CityUpdateRequest> updateRequests);
	
	@Override
	@Mapping(target = "id", ignore = true)
	public abstract void updateEntity(@MappingTarget City toUpdate, City newValue);
	
	@Override
	@Named("toResponse")
	@Mapping(source = "country.id", target = "countryId")
	public abstract CityResponse toResponse(City entity);
	
	@Override
	@IterableMapping(qualifiedByName = "toResponse")
	public abstract Collection<CityResponse> toResponses(Collection<City> entities);
	
	@Named("getCountryById")
	protected Country getCountryById(Integer id) throws FunctionalException {
		return countryService.findById(id);
	}

}