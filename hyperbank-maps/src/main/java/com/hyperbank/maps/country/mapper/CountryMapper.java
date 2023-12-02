package com.hyperbank.maps.country.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.hyperbank.maps.continent.entity.Continent;
import com.hyperbank.maps.continent.service.ContinentService;
import com.hyperbank.maps.country.dto.CountryResponse;
import com.hyperbank.maps.country.dto.CountrySaveRequest;
import com.hyperbank.maps.country.dto.CountryUpdateRequest;
import com.hyperbank.maps.country.entity.Country;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.service.helper.mapping.FullMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class CountryMapper implements FullMapper<Country, CountrySaveRequest, CountryUpdateRequest, CountryResponse> {

	@Autowired
	private ContinentService continentService;

	@Override
	@Named("fromSaveRequestToEntity")
	@Mapping(target = "id", ignore = true)
	@Mapping(source = "continentId", target = "continent", qualifiedByName = "getContinentById")
	public abstract Country fromSaveRequestToEntity(CountrySaveRequest saveRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToEntity")
	public abstract List<Country> fromSaveRequestsToEntities(Collection<CountrySaveRequest> saveRequests);

	@Override
	@Named("fromUpdateRequestToEntity")
	@Mapping(source = "continentId", target = "continent", qualifiedByName = "getContinentById")
	public abstract Country fromUpdateRequestToEntity(CountryUpdateRequest updateRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToEntity")
	public abstract List<Country> fromUpdateRequestsToEntities(Collection<CountryUpdateRequest> updateRequests);
	
	@Override
	@Mapping(target = "id", ignore = true)
	public abstract void updateEntity(@MappingTarget Country toUpdate, Country newValue);
	
	@Override
	@Named("toResponse")
	@Mapping(source = "continent.id", target = "continentId")
	public abstract CountryResponse toResponse(Country entity);

	@Override
	@IterableMapping(qualifiedByName = "toResponse")
	public abstract List<CountryResponse> toResponses(Collection<Country> entities);

	@Named("getContinentById")
	protected Continent getContinentById(Integer id) throws FunctionalException {
		return continentService.findById(id);
	}

}
