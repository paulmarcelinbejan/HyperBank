package com.hyperbank.interests.interestratefixed.controller;

import java.util.Collection;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyperbank.interests.interestratefixed.dto.InterestRateFixedResponse;
import com.hyperbank.interests.interestratefixed.dto.InterestRateFixedSaveRequest;
import com.hyperbank.interests.interestratefixed.mapper.InterestRateFixedMapper;
import com.hyperbank.interests.interestratefixed.service.InterestRateFixedService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/interestratefixed")
public class InterestRateFixedRestController {

	private final InterestRateFixedService interestRateFixedService;
	
	private final InterestRateFixedMapper interestRateFixedMapper;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody InterestRateFixedResponse findById(@PathVariable Long id) throws FunctionalException {
		return interestRateFixedMapper.toResponse(interestRateFixedService.findById(id));
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<InterestRateFixedResponse> findAll() {
		return interestRateFixedMapper.toResponses(interestRateFixedService.findAll());
	}

	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Long save(@Valid @RequestBody final InterestRateFixedSaveRequest saveRequest) {
		return interestRateFixedService.save(interestRateFixedMapper.fromSaveRequestToEntity(saveRequest));
	}

	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Long> save(@RequestBody final Collection<InterestRateFixedSaveRequest> saveRequests) {
		ValidatorUtils.validateAll(saveRequests);
		return interestRateFixedService.save(interestRateFixedMapper.fromSaveRequestsToEntities(saveRequests));
	}

}
