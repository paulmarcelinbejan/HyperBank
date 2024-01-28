package com.hyperbank.maps.continent.api.update.many;

import java.util.List;

import com.hyperbank.maps.continent.dto.ContinentResponse;
import com.hyperbank.maps.continent.dto.ContinentUpdateRequest;
import com.hyperbank.maps.continent.entity.Continent;
import com.hyperbank.maps.continent.mapper.EntitiesToDtosContinentMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorFull;

@Coordinator
public class UpdateManyContinentCoordinatorImpl extends CoordinatorFull<List<ContinentUpdateRequest>, List<Continent>, List<Continent>, List<ContinentResponse>> implements UpdateManyContinentCoordinator {

	public UpdateManyContinentCoordinatorImpl(
			ContinentUpdateRequestsValidator validator,
			UpdateManyContinentMapper mapperInput, 
			UpdateManyContinentService service,
			EntitiesToDtosContinentMapper mapperOutput) {
		super(validator, mapperInput, service, mapperOutput);
	}
	
}
