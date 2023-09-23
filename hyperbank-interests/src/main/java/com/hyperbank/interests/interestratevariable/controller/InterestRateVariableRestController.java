package com.hyperbank.interests.interestratevariable.controller;

import java.util.Collection;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyperbank.interests.interestratevariable.dto.InterestRateVariableResponse;
import com.hyperbank.interests.interestratevariable.dto.InterestRateVariableSaveRequest;
import com.hyperbank.interests.interestratevariable.dto.InterestRateVariableUpdateRequest;
import com.hyperbank.interests.interestratevariable.mapper.InterestRateVariableMapper;
import com.hyperbank.interests.interestratevariable.service.InterestRateVariableService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/interestratevariable")
public class InterestRateVariableRestController {

	private final InterestRateVariableService interestRateVariableService;
	
	private final InterestRateVariableMapper interestRateVariableMapper;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody InterestRateVariableResponse findById(@PathVariable Long id) throws FunctionalException {
		return interestRateVariableMapper.toResponse(interestRateVariableService.findById(id));
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<InterestRateVariableResponse> findAll() {
		return interestRateVariableMapper.toResponses(interestRateVariableService.findAll());
	}

	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Long save(@Valid @RequestBody final InterestRateVariableSaveRequest saveRequest) {
		return interestRateVariableService.save(interestRateVariableMapper.fromSaveRequestToEntity(saveRequest));
	}

	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Long> save(@RequestBody final Collection<InterestRateVariableSaveRequest> saveRequests) {
		ValidatorUtils.validateAll(saveRequests);
		return interestRateVariableService.save(interestRateVariableMapper.fromSaveRequestsToEntities(saveRequests));
	}
	
	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Long update(@Valid @RequestBody final InterestRateVariableUpdateRequest updateRequest) throws FunctionalException {
		return interestRateVariableService.update(interestRateVariableMapper.fromUpdateRequestToEntity(updateRequest));
	}

	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Long> update(@RequestBody final Collection<InterestRateVariableUpdateRequest> updateRequests) throws FunctionalException {
		ValidatorUtils.validateAll(updateRequests);
		return interestRateVariableService.update(interestRateVariableMapper.fromUpdateRequestsToEntities(updateRequests));
	}

}
