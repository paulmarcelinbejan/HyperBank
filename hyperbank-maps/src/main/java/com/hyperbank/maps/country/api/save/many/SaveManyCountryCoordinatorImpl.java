package com.hyperbank.maps.country.api.save.many;

import java.util.List;

import com.hyperbank.maps.country.dto.CountryResponse;
import com.hyperbank.maps.country.dto.CountrySaveRequest;
import com.hyperbank.maps.country.entity.Country;
import com.hyperbank.maps.country.mapper.EntitiesToDtosCountryMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorFull;

@Coordinator
public class SaveManyCountryCoordinatorImpl extends CoordinatorFull<List<CountrySaveRequest>, List<Country>, List<Country>, List<CountryResponse>> implements SaveManyCountryCoordinator {

	public SaveManyCountryCoordinatorImpl(
			CountrySaveRequestsValidator validator,
			SaveManyCountryMapper mapperInput, 
			SaveManyCountryService service,
			EntitiesToDtosCountryMapper mapperOutput) {
		super(validator, mapperInput, service, mapperOutput);
	}
	
}
