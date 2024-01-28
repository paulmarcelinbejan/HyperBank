package com.hyperbank.maps.city.api.find.all;

import java.util.List;

import com.hyperbank.maps.city.dto.CityResponse;
import com.hyperbank.maps.city.entity.City;
import com.hyperbank.maps.city.mapper.EntitiesToDtosCityMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorServiceResponse;

@Coordinator
public class FindAllCityCoordinatorImpl extends CoordinatorServiceResponse<List<City>, List<CityResponse>> implements FindAllCityCoordinator {

	public FindAllCityCoordinatorImpl(
			FindAllCityService service,
			EntitiesToDtosCityMapper mapper) {
		super(service, mapper);
	}
	
}
