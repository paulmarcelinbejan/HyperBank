package com.hyperbank.interests.interestratetype.controller;

import java.util.List;

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

import com.hyperbank.interests.interestratetype.dto.InterestRateTypeResponse;
import com.hyperbank.interests.interestratetype.dto.InterestRateTypeSaveRequest;
import com.hyperbank.interests.interestratetype.dto.InterestRateTypeUpdateRequest;
import com.hyperbank.interests.interestratetype.mapper.InterestRateTypeMapper;
import com.hyperbank.interests.interestratetype.service.InterestRateTypeService;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;
import io.github.paulmarcelinbejan.toolbox.web.response.OkResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/interestratetype")
public class InterestRateTypeRestController {

	private final InterestRateTypeService interestRateTypeService;
	
	private final InterestRateTypeMapper interestRateTypeMapper;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody InterestRateTypeResponse findById(@PathVariable Integer id) throws FunctionalException {
		return interestRateTypeMapper.toResponse(interestRateTypeService.findById(id));
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<InterestRateTypeResponse> findAll() {
		return interestRateTypeMapper.toResponses(interestRateTypeService.findAll());
	}

	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Integer save(@Valid @RequestBody final InterestRateTypeSaveRequest saveRequest) throws FunctionalException {
		return interestRateTypeService.save(interestRateTypeMapper.fromSaveRequestToEntity(saveRequest));
	}

	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Integer> save(@RequestBody final List<InterestRateTypeSaveRequest> saveRequests) throws FunctionalException {
		ValidatorUtils.validateAll(saveRequests);
		return interestRateTypeService.save(interestRateTypeMapper.fromSaveRequestsToEntities(saveRequests));
	}

	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Integer update(@Valid @RequestBody final InterestRateTypeUpdateRequest updateRequest) throws FunctionalException {
		return interestRateTypeService.update(interestRateTypeMapper.fromUpdateRequestToEntity(updateRequest));
	}

	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Integer> update(@RequestBody final List<InterestRateTypeUpdateRequest> updateRequests) throws FunctionalException {
		ValidatorUtils.validateAll(updateRequests);
		return interestRateTypeService.update(interestRateTypeMapper.fromUpdateRequestsToEntities(updateRequests));
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable Integer id) throws FunctionalException {
		interestRateTypeService.delete(id);
		return new OkResponse();
	}

	@DeleteMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestBody List<Integer> ids) throws FunctionalException {
		interestRateTypeService.deleteMany(ids);
		return new OkResponse();
	}

}
