package com.hyperbank.maps.city.api.update.one;

import com.hyperbank.maps.city.dto.CityResponse;
import com.hyperbank.maps.city.dto.CityUpdateRequest;
import com.hyperbank.maps.city.entity.City;
import com.hyperbank.maps.city.mapper.EntityToDtoCityMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorFull;

@Coordinator
public class UpdateOneCityCoordinatorImpl extends CoordinatorFull<CityUpdateRequest, City, City, CityResponse> implements UpdateOneCityCoordinator {

	public UpdateOneCityCoordinatorImpl(
			CityUpdateRequestValidator validator,
			UpdateOneCityMapper mapperInput, 
			UpdateOneCityService service,
			EntityToDtoCityMapper mapperOutput) {
		super(validator, mapperInput, service, mapperOutput);
	}
	
}
