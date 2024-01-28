package com.hyperbank.maps.location.api.save.many;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.maps.location.api.save.one.SaveOneLocationMapper;
import com.hyperbank.maps.location.dto.LocationSaveRequest;
import com.hyperbank.maps.location.entity.Location;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.input.MapperInput;

@Mapper(config = HyperBankMapperConfig.class,
		uses = SaveOneLocationMapper.class)
public interface SaveManyLocationMapper extends  
	MapperInput<List<LocationSaveRequest>, List<Location>> {
	
	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToDomain")
	List<Location> toDomain(List<LocationSaveRequest> request);
	
}