package com.hyperbank.maps.country.api.find.many;

import java.util.List;

import com.hyperbank.maps.country.dto.CountryResponse;
import com.hyperbank.maps.country.entity.Country;
import com.hyperbank.maps.country.mapper.EntitiesToDtosCountryMapper;

import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.Coordinator;
import io.github.paulmarcelinbejan.coordinator.architecture.coordinator.base.CoordinatorWithoutInputMapping;
import io.github.paulmarcelinbejan.coordinator.architecture.validator.id.base.IntegerIdsValidator;

@Coordinator
public class FindManyCountryCoordinatorImpl extends CoordinatorWithoutInputMapping<List<Integer>, List<Country>, List<CountryResponse>> implements FindManyCountryCoordinator {

	public FindManyCountryCoordinatorImpl(
			IntegerIdsValidator validator,
			FindManyCountryService service,
			EntitiesToDtosCountryMapper mapper) {
		super(validator, service, mapper);
	}
	
}
