package com.hyperbank.maps.city.api.save.many;

import java.util.List;

import com.hyperbank.maps.city.dto.CityResponse;
import com.hyperbank.maps.city.dto.CitySaveRequest;
import com.hyperbank.maps.city.entity.City;
import com.hyperbank.maps.city.mapper.EntitiesToDtosCityMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorFull;

@Coordinator
public class SaveManyCityCoordinatorImpl extends CoordinatorFull<List<CitySaveRequest>, List<City>, List<City>, List<CityResponse>> implements SaveManyCityCoordinator {

	public SaveManyCityCoordinatorImpl(
			CitySaveRequestsValidator validator,
			SaveManyCityMapper mapperInput, 
			SaveManyCityService service,
			EntitiesToDtosCityMapper mapperOutput) {
		super(validator, mapperInput, service, mapperOutput);
	}
	
}
