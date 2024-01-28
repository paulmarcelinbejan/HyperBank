package com.hyperbank.maps.city.api.save.many;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.maps.city.api.save.one.SaveOneCityMapper;
import com.hyperbank.maps.city.dto.CitySaveRequest;
import com.hyperbank.maps.city.entity.City;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.input.MapperInput;

@Mapper(config = HyperBankMapperConfig.class,
		uses = SaveOneCityMapper.class)
public interface SaveManyCityMapper extends  
	MapperInput<List<CitySaveRequest>, List<City>> {
	
	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToDomain")
	List<City> toDomain(List<CitySaveRequest> request);
	
}