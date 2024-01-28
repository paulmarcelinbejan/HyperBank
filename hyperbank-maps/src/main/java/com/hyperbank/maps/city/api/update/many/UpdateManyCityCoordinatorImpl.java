package com.hyperbank.maps.city.api.update.many;

import java.util.List;

import com.hyperbank.maps.city.dto.CityResponse;
import com.hyperbank.maps.city.dto.CityUpdateRequest;
import com.hyperbank.maps.city.entity.City;
import com.hyperbank.maps.city.mapper.EntitiesToDtosCityMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorFull;

@Coordinator
public class UpdateManyCityCoordinatorImpl extends CoordinatorFull<List<CityUpdateRequest>, List<City>, List<City>, List<CityResponse>> implements UpdateManyCityCoordinator {

	public UpdateManyCityCoordinatorImpl(
			CityUpdateRequestsValidator validator,
			UpdateManyCityMapper mapperInput, 
			UpdateManyCityService service,
			EntitiesToDtosCityMapper mapperOutput) {
		super(validator, mapperInput, service, mapperOutput);
	}
	
}
