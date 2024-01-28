package com.hyperbank.maps.continent.api.save.many;

import java.util.List;

import com.hyperbank.maps.continent.dto.ContinentResponse;
import com.hyperbank.maps.continent.dto.ContinentSaveRequest;
import com.hyperbank.maps.continent.entity.Continent;
import com.hyperbank.maps.continent.mapper.EntitiesToDtosContinentMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorFull;

@Coordinator
public class SaveManyContinentCoordinatorImpl extends CoordinatorFull<List<ContinentSaveRequest>, List<Continent>, List<Continent>, List<ContinentResponse>> implements SaveManyContinentCoordinator {

	public SaveManyContinentCoordinatorImpl(
			ContinentSaveRequestsValidator validator,
			SaveManyContinentMapper mapperInput, 
			SaveManyContinentService service,
			EntitiesToDtosContinentMapper mapperOutput) {
		super(validator, mapperInput, service, mapperOutput);
	}
	
}
