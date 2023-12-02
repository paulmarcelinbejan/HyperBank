package com.hyperbank.maps.location.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.hyperbank.maps.city.entity.City;
import com.hyperbank.maps.city.service.CityService;
import com.hyperbank.maps.location.dto.LocationResponse;
import com.hyperbank.maps.location.dto.LocationSaveRequest;
import com.hyperbank.maps.location.dto.LocationUpdateRequest;
import com.hyperbank.maps.location.entity.Location;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.service.helper.mapping.FullMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class LocationMapper implements FullMapper<Location, LocationSaveRequest, LocationUpdateRequest, LocationResponse> {

	@Autowired
	private CityService cityService;

	@Override
	@Named("fromSaveRequestToEntity")
	@Mapping(target = "id", ignore = true)
	@Mapping(source = "cityId", target = "city", qualifiedByName = "getCityById")
	public abstract Location fromSaveRequestToEntity(LocationSaveRequest saveRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToEntity")
	public abstract List<Location> fromSaveRequestsToEntities(Collection<LocationSaveRequest> saveRequests);
	
	@Override
	@Named("fromUpdateRequestToEntity")
	@Mapping(source = "cityId", target = "city", qualifiedByName = "getCityById")
	public abstract Location fromUpdateRequestToEntity(LocationUpdateRequest updateRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToEntity")
	public abstract List<Location> fromUpdateRequestsToEntities(Collection<LocationUpdateRequest> updateRequests);

	@Override
	@Mapping(target = "id", ignore = true)
	public abstract void updateEntity(@MappingTarget Location toUpdate, Location newValue);
	
	@Override
	@Named("toResponse")
	@Mapping(source = "city.id", target = "cityId")
	public abstract LocationResponse toResponse(Location entity);

	@Override
	@IterableMapping(qualifiedByName = "toResponse")
	public abstract List<LocationResponse> toResponses(Collection<Location> entities);

	@Named("getCityById")
	protected City getCityById(Integer id) throws FunctionalException {
		return cityService.findById(id);
	}

}
