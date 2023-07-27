package com.hyperbank.maps.city.controller;

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

import com.hyperbank.maps.city.dto.CityDto;
import com.hyperbank.maps.city.service.CityService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;
import com.paulmarcelinbejan.toolbox.web.response.OkResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/city")
public class CityRestController {

	private final CityService cityService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CityDto findById(@PathVariable Integer id) throws FunctionalException {
		return cityService.findByIdToDto(id);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<CityDto> findAll() {
		return cityService.findAllToDto();
	}

	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Integer
			save(@Validated(CityDto.CreateValidation.class) @RequestBody final CityDto dto)
					throws TechnicalException {
		return cityService.save(dto);
	}

	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Integer> save(@RequestBody final Collection<CityDto> dtos)
			throws TechnicalException {
		ValidatorUtils.validateGroups(dtos, CityDto.CreateValidation.class);
		return cityService.save(dtos);
	}

	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Integer
			update(@Validated(CityDto.UpdateValidation.class) @RequestBody final CityDto dto)
					throws FunctionalException, TechnicalException {
		return cityService.update(dto);
	}

	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Integer> update(@RequestBody final Collection<CityDto> dtos)
			throws FunctionalException, TechnicalException {
		ValidatorUtils.validateGroups(dtos, CityDto.UpdateValidation.class);
		return cityService.update(dtos);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable Integer id) throws FunctionalException {
		cityService.delete(id);
		return new OkResponse();
	}

	@DeleteMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestBody Collection<Integer> ids) throws FunctionalException {
		cityService.delete(ids);
		return new OkResponse();
	}

}
