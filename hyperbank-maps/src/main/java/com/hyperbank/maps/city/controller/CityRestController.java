package com.hyperbank.maps.city.controller;

import java.util.Collection;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyperbank.maps.city.dto.CityResponse;
import com.hyperbank.maps.city.dto.CitySaveRequest;
import com.hyperbank.maps.city.dto.CityUpdateRequest;
import com.hyperbank.maps.city.mapper.CityMapper;
import com.hyperbank.maps.city.service.CityService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;
import com.paulmarcelinbejan.toolbox.web.response.OkResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/city")
public class CityRestController {
	
	private final CityService cityService;
	
	private final CityMapper cityMapper;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CityResponse findById(@PathVariable Integer id) throws FunctionalException {
		return cityMapper.toResponse(cityService.findById(id));
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<CityResponse> findAll() {
		return cityMapper.toResponses(cityService.findAll());
	}

	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Integer save(@Valid @RequestBody final CitySaveRequest saveRequest) throws FunctionalException {
		return cityService.save(cityMapper.fromSaveRequestToEntity(saveRequest));
	}

	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Integer> save(@RequestBody final Collection<CitySaveRequest> saveRequests) throws FunctionalException {
		ValidatorUtils.validateAll(saveRequests);
		return cityService.save(cityMapper.fromSaveRequestsToEntities(saveRequests));
	}

	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Integer update(@Valid @RequestBody final CityUpdateRequest updateRequest) throws FunctionalException {
		return cityService.update(cityMapper.fromUpdateRequestToEntity(updateRequest));
	}

	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Integer> update(@RequestBody final Collection<CityUpdateRequest> updateRequests) throws FunctionalException {
		ValidatorUtils.validateAll(updateRequests);
		return cityService.update(cityMapper.fromUpdateRequestsToEntities(updateRequests));
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable Integer id) throws FunctionalException {
		cityService.delete(id);
		return new OkResponse();
	}

	@DeleteMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestBody Collection<Integer> ids) throws FunctionalException {
		cityService.deleteMany(ids);
		return new OkResponse();
	}

}
