package com.hyperbank.maps.continent.api.find.one;

import com.hyperbank.maps.continent.dto.ContinentResponse;
import com.hyperbank.maps.continent.entity.Continent;
import com.hyperbank.maps.continent.mapper.EntityToDtoContinentMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutInputMapping;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base.IntegerIdValidator;

@Coordinator
public class FindOneContinentCoordinatorImpl extends CoordinatorWithoutInputMapping<Integer, Continent, ContinentResponse> implements FindOneContinentCoordinator {

	public FindOneContinentCoordinatorImpl(
			IntegerIdValidator validator,
			EntityToDtoContinentMapper mapper, 
			FindOneContinentService service) {
		super(validator, service, mapper);
	}
	
}
