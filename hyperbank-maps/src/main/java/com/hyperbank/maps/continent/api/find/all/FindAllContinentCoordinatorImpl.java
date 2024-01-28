package com.hyperbank.maps.continent.api.find.all;

import java.util.List;

import com.hyperbank.maps.continent.dto.ContinentResponse;
import com.hyperbank.maps.continent.entity.Continent;
import com.hyperbank.maps.continent.mapper.EntitiesToDtosContinentMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorServiceResponse;

@Coordinator
public class FindAllContinentCoordinatorImpl extends CoordinatorServiceResponse<List<Continent>, List<ContinentResponse>> implements FindAllContinentCoordinator {

	public FindAllContinentCoordinatorImpl(
			FindAllContinentService service,
			EntitiesToDtosContinentMapper mapper) {
		super(service, mapper);
	}
	
}
