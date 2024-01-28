package com.hyperbank.maps.country.api.update.many;

import java.util.List;

import com.hyperbank.maps.country.dto.CountryResponse;
import com.hyperbank.maps.country.dto.CountryUpdateRequest;
import com.hyperbank.maps.country.entity.Country;
import com.hyperbank.maps.country.mapper.EntitiesToDtosCountryMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorFull;

@Coordinator
public class UpdateManyCountryCoordinatorImpl extends CoordinatorFull<List<CountryUpdateRequest>, List<Country>, List<Country>, List<CountryResponse>> implements UpdateManyCountryCoordinator {

	public UpdateManyCountryCoordinatorImpl(
			CountryUpdateRequestsValidator validator,
			UpdateManyCountryMapper mapperInput, 
			UpdateManyCountryService service,
			EntitiesToDtosCountryMapper mapperOutput) {
		super(validator, mapperInput, service, mapperOutput);
	}
	
}
