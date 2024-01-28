package com.hyperbank.maps.location.api.update.one;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.maps.city.api.find.one.FindOneCityService;
import com.hyperbank.maps.city.entity.City;
import com.hyperbank.maps.location.api.find.one.FindOneLocationService;
import com.hyperbank.maps.location.dto.LocationUpdateRequest;
import com.hyperbank.maps.location.entity.Location;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.input.MapperInput;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

@Mapper(config = HyperBankMapperConfig.class)
public abstract class UpdateOneLocationMapper implements 
	MapperInput<LocationUpdateRequest, Location> {
	
	@Autowired
	private FindOneLocationService findOneLocationService;
	
	@Autowired
	private FindOneCityService findOneCityService;
	
	@Override
	@Named("fromUpdateRequestToDomain")
	public Location toDomain(LocationUpdateRequest request) throws FunctionalException, TechnicalException {
		Location location = findOneLocationService.execute(request.getId());
		return updateLocation(request, location);
	}
	
	@Mapping(target = "id", ignore = true)
	@Mapping(source = "cityId", target = "city", qualifiedByName = "getCityById")
	public abstract Location updateLocation(LocationUpdateRequest request, @MappingTarget Location location);
	
	@Named("getCityById")
	protected City getCityById(Integer id) throws FunctionalException {
		return findOneCityService.execute(id);
	}
	
}