package com.hyperbank.maps.country.api.save.one;

import com.hyperbank.maps.country.dto.CountryResponse;
import com.hyperbank.maps.country.dto.CountrySaveRequest;
import com.hyperbank.maps.country.entity.Country;
import com.hyperbank.maps.country.mapper.EntityToDtoCountryMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorFull;

@Coordinator
public class SaveOneCountryCoordinatorImpl extends CoordinatorFull<CountrySaveRequest, Country, Country, CountryResponse> implements SaveOneCountryCoordinator {

	public SaveOneCountryCoordinatorImpl(
			CountrySaveRequestValidator validator,
			SaveOneCountryMapper mapperInput, 
			SaveOneCountryService service,
			EntityToDtoCountryMapper mapperOutput) {
		super(validator, mapperInput, service, mapperOutput);
	}
	
}
