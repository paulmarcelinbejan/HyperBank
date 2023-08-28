package com.hyperbank.maps.continent.mapper;

import java.util.Collection;

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
import com.paulmarcelinbejan.toolbox.utils.mapping.BaseFullMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContinentMapper extends BaseFullMapper<Continent, ContinentSaveRequest, ContinentUpdateRequest, ContinentResponse> {

	@Override
	@Named("fromSaveRequestToEntity")
	@Mapping(target = "id", ignore = true)
	Continent fromSaveRequestToEntity(ContinentSaveRequest saveRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToEntity")
	Collection<Continent> fromSaveRequestsToEntities(Collection<ContinentSaveRequest> saveRequests);
	
	@Override
	@Named("fromUpdateRequestToEntity")
	Continent fromUpdateRequestToEntity(ContinentUpdateRequest updateRequest);
	
	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToEntity")
	Collection<Continent> fromUpdateRequestsToEntities(Collection<ContinentUpdateRequest> updateRequests);
	
	@Override
	@Mapping(target = "id", ignore = true)
	void updateEntity(@MappingTarget Continent toUpdate, Continent newValue);

	@Override
	@Named("toResponse")
	ContinentResponse toResponse(Continent entity);

	@Override
	@IterableMapping(qualifiedByName = "toResponse")
	Collection<ContinentResponse> toResponses(Collection<Continent> entities);

}
