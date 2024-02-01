package com.hyperbank.maps.city.mapper;

import java.util.Collections;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import com.hyperbank.architecture.web.mapper.config.HyperBankMapperConfig;
import com.hyperbank.maps.city.entity.City;

import io.github.paulmarcelinbejan.coordinator.architecture.mapper.output.MapperOutput;
import io.github.paulmarcelinbejan.toolbox.web.response.PagedResponse;

@Mapper(config = HyperBankMapperConfig.class, 
		uses = { EntitiesToDtosCityMapper.class }, 
		imports = Collections.class)
public interface PagedEntitiesToPagedResponseCityMapper 
		extends MapperOutput<Page<City>, PagedResponse> {

	@Override
	@Mapping(target = "list", source = "content", qualifiedByName = "fromEntitiesToDtos", defaultExpression = "java( Collections.emptyList() )")
	@Mapping(target = "totalElements", source = "totalElements")
	@Mapping(target = "totalPages", source = "totalPages")
	PagedResponse toResponse(Page<City> entities);

}