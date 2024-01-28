package com.hyperbank.maps.city.api.find.one;

import com.hyperbank.maps.city.dto.CityResponse;
import com.hyperbank.maps.city.entity.City;
import com.hyperbank.maps.city.mapper.EntityToDtoCityMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutInputMapping;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base.IntegerIdValidator;

@Coordinator
public class FindOneCityCoordinatorImpl extends CoordinatorWithoutInputMapping<Integer, City, CityResponse> implements FindOneCityCoordinator {

	public FindOneCityCoordinatorImpl(
			IntegerIdValidator validator,
			EntityToDtoCityMapper mapper, 
			FindOneCityService service) {
		super(validator, service, mapper);
	}
	
}
