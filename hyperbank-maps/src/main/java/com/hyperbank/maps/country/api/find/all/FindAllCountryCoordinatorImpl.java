package com.hyperbank.maps.country.api.find.all;

import java.util.List;

import com.hyperbank.maps.country.dto.CountryResponse;
import com.hyperbank.maps.country.entity.Country;
import com.hyperbank.maps.country.mapper.EntitiesToDtosCountryMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorServiceResponse;

@Coordinator
public class FindAllCountryCoordinatorImpl extends CoordinatorServiceResponse<List<Country>, List<CountryResponse>> implements FindAllCountryCoordinator {

	public FindAllCountryCoordinatorImpl(
			FindAllCountryService service,
			EntitiesToDtosCountryMapper mapper) {
		super(service, mapper);
	}
	
}
