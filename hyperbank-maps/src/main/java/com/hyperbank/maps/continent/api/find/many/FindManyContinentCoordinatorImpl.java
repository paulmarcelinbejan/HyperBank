package com.hyperbank.maps.continent.api.find.many;

import java.util.List;

import com.hyperbank.maps.continent.dto.ContinentResponse;
import com.hyperbank.maps.continent.entity.Continent;
import com.hyperbank.maps.continent.mapper.EntitiesToDtosContinentMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutInputMapping;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base.IntegerIdsValidator;

@Coordinator
public class FindManyContinentCoordinatorImpl extends CoordinatorWithoutInputMapping<List<Integer>, List<Continent>, List<ContinentResponse>> implements FindManyContinentCoordinator {

	public FindManyContinentCoordinatorImpl(
			IntegerIdsValidator validator,
			FindManyContinentService service,
			EntitiesToDtosContinentMapper mapper) {
		super(validator, service, mapper);
	}
	
}
