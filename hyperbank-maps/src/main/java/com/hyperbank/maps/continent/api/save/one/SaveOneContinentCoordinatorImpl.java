package com.hyperbank.maps.continent.api.save.one;

import com.hyperbank.maps.continent.dto.ContinentResponse;
import com.hyperbank.maps.continent.dto.ContinentSaveRequest;
import com.hyperbank.maps.continent.entity.Continent;
import com.hyperbank.maps.continent.mapper.EntityToDtoContinentMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorFull;

@Coordinator
public class SaveOneContinentCoordinatorImpl extends CoordinatorFull<ContinentSaveRequest, Continent, Continent, ContinentResponse> implements SaveOneContinentCoordinator {

	public SaveOneContinentCoordinatorImpl(
			ContinentSaveRequestValidator validator,
			SaveOneContinentMapper mapperInput, 
			SaveOneContinentService service,
			EntityToDtoContinentMapper mapperOutput) {
		super(validator, mapperInput, service, mapperOutput);
	}
	
}
