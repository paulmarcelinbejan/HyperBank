package com.hyperbank.maps.location.controller;

import java.util.Collection;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyperbank.maps.location.dto.LocationDto;
import com.hyperbank.maps.location.mapper.LocationMapper;
import com.hyperbank.maps.location.service.LocationService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;
import com.paulmarcelinbejan.toolbox.web.response.OkResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/location")
public class LocationRestController {

	private final LocationService locationService;
	
	private final LocationMapper locationMapper;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody LocationDto findById(@PathVariable Long id) throws FunctionalException {
		return locationMapper.toDto(locationService.findById(id));
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<LocationDto> findAll() {
		return locationMapper.toDtos(locationService.findAll());
	}

	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Long save(@Validated(LocationDto.CreateValidation.class) @RequestBody final LocationDto dto) {
		return locationService.save(locationMapper.toEntity(dto));
	}

	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Long> save(@RequestBody final Collection<LocationDto> dtos) {
		ValidatorUtils.validateGroups(dtos, LocationDto.CreateValidation.class);
		return locationService.save(locationMapper.toEntities(dtos));
	}

	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Long update(@Validated(LocationDto.UpdateValidation.class) @RequestBody final LocationDto dto) throws FunctionalException {
		return locationService.update(locationMapper.toEntity(dto));
	}

	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Long> update(@RequestBody final Collection<LocationDto> dtos) throws FunctionalException {
		ValidatorUtils.validateGroups(dtos, LocationDto.UpdateValidation.class);
		return locationService.update(locationMapper.toEntities(dtos));
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable Long id) throws FunctionalException {
		locationService.delete(id);
		return new OkResponse();
	}

	@DeleteMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestBody Collection<Long> ids) throws FunctionalException {
		locationService.deleteMany(ids);
		return new OkResponse();
	}

}
