package com.hyperbank.maps.city.api.save.one;

import com.hyperbank.maps.city.dto.CityResponse;
import com.hyperbank.maps.city.dto.CitySaveRequest;
import com.hyperbank.maps.city.entity.City;
import com.hyperbank.maps.city.mapper.EntityToDtoCityMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorFull;

@Coordinator
public class SaveOneCityCoordinatorImpl extends CoordinatorFull<CitySaveRequest, City, City, CityResponse> implements SaveOneCityCoordinator {

	public SaveOneCityCoordinatorImpl(
			CitySaveRequestValidator validator,
			SaveOneCityMapper mapperInput, 
			SaveOneCityService service,
			EntityToDtoCityMapper mapperOutput) {
		super(validator, mapperInput, service, mapperOutput);
	}
	
}
