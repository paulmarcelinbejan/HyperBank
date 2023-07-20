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
import com.hyperbank.maps.location.service.LocationService;
import com.paulmarcelinbejan.toolbox.exception.technical.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;
import com.paulmarcelinbejan.toolbox.web.dto.OkResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/location")
public class LocationRestController {

	private final LocationService locationService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody LocationDto findById(@PathVariable Long id) throws FunctionalException {
		return locationService.findByIdToDto(id);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<LocationDto> findAll() {
		return locationService.findAllToDto();
	}

	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Long
			save(@Validated(LocationDto.CreateValidation.class) @RequestBody final LocationDto dto)
					throws TechnicalException {
		return locationService.save(dto);
	}

	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Long> save(@RequestBody final Collection<LocationDto> dtos)
			throws TechnicalException {
		ValidatorUtils.validateGroups(dtos, LocationDto.CreateValidation.class);
		return locationService.save(dtos);
	}

	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Long
			update(@Validated(LocationDto.UpdateValidation.class) @RequestBody final LocationDto dto)
					throws FunctionalException, TechnicalException {
		return locationService.update(dto);
	}

	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Long> update(@RequestBody final Collection<LocationDto> dtos)
			throws FunctionalException, TechnicalException {
		ValidatorUtils.validateGroups(dtos, LocationDto.UpdateValidation.class);
		return locationService.update(dtos);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable Long id) throws FunctionalException {
		locationService.delete(id);
		return new OkResponse();
	}

	@DeleteMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestBody Collection<Long> ids) throws FunctionalException {
		locationService.delete(ids);
		return new OkResponse();
	}

}
