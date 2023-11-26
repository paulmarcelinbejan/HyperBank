package com.hyperbank.maps.continent.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import com.hyperbank.maps.continent.dto.ContinentResponse;
import com.hyperbank.maps.continent.dto.ContinentSaveRequest;
import com.hyperbank.maps.continent.dto.ContinentUpdateRequest;
import com.hyperbank.maps.continent.entity.Continent;
import com.paulmarcelinbejan.toolbox.service.helper.mapping.FullMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class ContinentMapper implements FullMapper<Continent, ContinentSaveRequest, ContinentUpdateRequest, ContinentResponse> {

	@Override
	@Named("fromSaveRequestToEntity")
	@Mapping(target = "id", ignore = true)
	public abstract Continent fromSaveRequestToEntity(ContinentSaveRequest saveRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToEntity")
	public abstract List<Continent> fromSaveRequestsToEntities(Collection<ContinentSaveRequest> saveRequests);

	@Override
	@Named("fromUpdateRequestToEntity")
	@Mapping(target = "id", ignore = true)
	public abstract Continent fromUpdateRequestToEntity(ContinentUpdateRequest updateRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToEntity")
	public abstract List<Continent> fromUpdateRequestsToEntities(Collection<ContinentUpdateRequest> updateRequests);

	@Override
	@Mapping(target = "id", ignore = true)
	public abstract void updateEntity(@MappingTarget Continent toUpdate, Continent newValue);

	@Override
	@Named("toResponse")
	public abstract ContinentResponse toResponse(Continent entity);

	@Override
	@IterableMapping(qualifiedByName = "toResponse")
	public abstract List<ContinentResponse> toResponses(Collection<Continent> entities);

}