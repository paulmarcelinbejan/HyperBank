package com.hyperbank.maps.continent.api.save.many;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.maps.continent.api.save.one.SaveOneContinentMapper;
import com.hyperbank.maps.continent.dto.ContinentSaveRequest;
import com.hyperbank.maps.continent.entity.Continent;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.input.MapperInput;

@Mapper(config = HyperBankMapperConfig.class,
		uses = SaveOneContinentMapper.class)
public interface SaveManyContinentMapper extends  
	MapperInput<List<ContinentSaveRequest>, List<Continent>> {
	
	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToDomain")
	List<Continent> toDomain(List<ContinentSaveRequest> request);
	
}