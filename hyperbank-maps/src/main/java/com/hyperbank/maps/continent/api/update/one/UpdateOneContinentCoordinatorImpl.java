package com.hyperbank.maps.continent.api.update.one;

import com.hyperbank.maps.continent.dto.ContinentResponse;
import com.hyperbank.maps.continent.dto.ContinentUpdateRequest;
import com.hyperbank.maps.continent.entity.Continent;
import com.hyperbank.maps.continent.mapper.EntityToDtoContinentMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorFull;

@Coordinator
public class UpdateOneContinentCoordinatorImpl extends CoordinatorFull<ContinentUpdateRequest, Continent, Continent, ContinentResponse> implements UpdateOneContinentCoordinator {

	public UpdateOneContinentCoordinatorImpl(
			ContinentUpdateRequestValidator validator,
			UpdateOneContinentMapper mapperInput, 
			UpdateOneContinentService service,
			EntityToDtoContinentMapper mapperOutput) {
		super(validator, mapperInput, service, mapperOutput);
	}
	
}
