package com.hyperbank.maps.location.api.save.one;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.maps.city.api.find.one.FindOneCityService;
import com.hyperbank.maps.city.entity.City;
import com.hyperbank.maps.location.dto.LocationSaveRequest;
import com.hyperbank.maps.location.entity.Location;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.input.MapperInput;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;

@Mapper(config = HyperBankMapperConfig.class)
public abstract class SaveOneLocationMapper implements 
	MapperInput<LocationSaveRequest, Location> {
	
	@Autowired
	private FindOneCityService findOneCityService;
	
	@Override
	@Named("fromSaveRequestToDomain")
	@Mapping(target = "id", ignore = true)
	@Mapping(source = "cityId", target = "city", qualifiedByName = "getCityById")
	public abstract Location toDomain(LocationSaveRequest request);
	
	@Named("getCityById")
	protected City getCityById(Integer id) throws FunctionalException {
		return findOneCityService.execute(id);
	}
	
}