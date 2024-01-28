package com.hyperbank.maps.country.api.find.one;

import com.hyperbank.maps.country.dto.CountryResponse;
import com.hyperbank.maps.country.entity.Country;
import com.hyperbank.maps.country.mapper.EntityToDtoCountryMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutInputMapping;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base.IntegerIdValidator;

@Coordinator
public class FindOneCountryCoordinatorImpl extends CoordinatorWithoutInputMapping<Integer, Country, CountryResponse> implements FindOneCountryCoordinator {

	public FindOneCountryCoordinatorImpl(
			IntegerIdValidator validator,
			EntityToDtoCountryMapper mapper, 
			FindOneCountryService service) {
		super(validator, service, mapper);
	}
	
}
