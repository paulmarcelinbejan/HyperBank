package com.hyperbank.maps.country.api.save.many;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.maps.country.api.save.one.SaveOneCountryMapper;
import com.hyperbank.maps.country.dto.CountrySaveRequest;
import com.hyperbank.maps.country.entity.Country;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.input.MapperInput;

@Mapper(config = HyperBankMapperConfig.class,
		uses = SaveOneCountryMapper.class)
public interface SaveManyCountryMapper extends  
	MapperInput<List<CountrySaveRequest>, List<Country>> {
	
	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToDomain")
	List<Country> toDomain(List<CountrySaveRequest> request);
	
}