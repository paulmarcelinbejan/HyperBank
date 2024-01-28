package com.hyperbank.maps.city.api.find.many;

import java.util.List;

import com.hyperbank.maps.city.dto.CityResponse;
import com.hyperbank.maps.city.entity.City;
import com.hyperbank.maps.city.mapper.EntitiesToDtosCityMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutInputMapping;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base.IntegerIdsValidator;

@Coordinator
public class FindManyCityCoordinatorImpl extends CoordinatorWithoutInputMapping<List<Integer>, List<City>, List<CityResponse>> implements FindManyCityCoordinator {

	public FindManyCityCoordinatorImpl(
			IntegerIdsValidator validator,
			FindManyCityService service,
			EntitiesToDtosCityMapper mapper) {
		super(validator, service, mapper);
	}
	
}
