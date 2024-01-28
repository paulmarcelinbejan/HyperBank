package com.hyperbank.maps.country.api.update.one;

import com.hyperbank.maps.country.dto.CountryResponse;
import com.hyperbank.maps.country.dto.CountryUpdateRequest;
import com.hyperbank.maps.country.entity.Country;
import com.hyperbank.maps.country.mapper.EntityToDtoCountryMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorFull;

@Coordinator
public class UpdateOneCountryCoordinatorImpl extends CoordinatorFull<CountryUpdateRequest, Country, Country, CountryResponse> implements UpdateOneCountryCoordinator {

	public UpdateOneCountryCoordinatorImpl(
			CountryUpdateRequestValidator validator,
			UpdateOneCountryMapper mapperInput, 
			UpdateOneCountryService service,
			EntityToDtoCountryMapper mapperOutput) {
		super(validator, mapperInput, service, mapperOutput);
	}
	
}
