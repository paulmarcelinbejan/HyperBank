package com.hyperbank.maps.country.controller;

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

import com.hyperbank.maps.country.dto.CountryDto;
import com.hyperbank.maps.country.service.CountryService;
import com.paulmarcelinbejan.toolbox.exception.technical.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;
import com.paulmarcelinbejan.toolbox.web.dto.OkResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/country")
public class CountryRestController {

	private final CountryService countryService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CountryDto findById(@PathVariable Integer id) throws FunctionalException {
		return countryService.findByIdToDto(id);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<CountryDto> findAll() {
		return countryService.findAllToDto();
	}

	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Integer
			save(@Validated(CountryDto.CreateValidation.class) @RequestBody final CountryDto dto)
					throws TechnicalException {
		return countryService.save(dto);
	}

	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Integer> save(@RequestBody final Collection<CountryDto> dtos)
			throws TechnicalException {
		ValidatorUtils.validateGroups(dtos, CountryDto.CreateValidation.class);
		return countryService.save(dtos);
	}

	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Integer
			update(@Validated(CountryDto.UpdateValidation.class) @RequestBody final CountryDto dto)
					throws FunctionalException, TechnicalException {
		return countryService.update(dto);
	}

	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Integer> update(@RequestBody final Collection<CountryDto> dtos)
			throws FunctionalException, TechnicalException {
		ValidatorUtils.validateGroups(dtos, CountryDto.UpdateValidation.class);
		return countryService.update(dtos);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable Integer id) throws FunctionalException {
		countryService.delete(id);
		return new OkResponse();
	}

	@DeleteMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestBody Collection<Integer> ids) throws FunctionalException {
		countryService.delete(ids);
		return new OkResponse();
	}

}
