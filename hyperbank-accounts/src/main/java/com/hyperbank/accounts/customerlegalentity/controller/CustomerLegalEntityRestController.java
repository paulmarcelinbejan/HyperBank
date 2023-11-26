package com.hyperbank.accounts.customerlegalentity.controller;

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

import com.hyperbank.accounts.customerlegalentity.dto.CustomerLegalEntityResponse;
import com.hyperbank.accounts.customerlegalentity.dto.CustomerLegalEntitySaveRequest;
import com.hyperbank.accounts.customerlegalentity.dto.CustomerLegalEntityUpdateRequest;
import com.hyperbank.accounts.customerlegalentity.mapper.CustomerLegalEntityMapper;
import com.hyperbank.accounts.customerlegalentity.service.CustomerLegalEntityService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;
import com.paulmarcelinbejan.toolbox.web.response.OkResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customerlegalentity")
public class CustomerLegalEntityRestController {

	private final CustomerLegalEntityService customerLegalEntityService;
	
	private final CustomerLegalEntityMapper customerLegalEntityMapper;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CustomerLegalEntityResponse findById(@PathVariable Long id) throws FunctionalException {
		return customerLegalEntityMapper.toResponse(customerLegalEntityService.findById(id));
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CustomerLegalEntityResponse> findAll() {
		return customerLegalEntityMapper.toResponses(customerLegalEntityService.findAll());
	}

	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Long save(@Valid @RequestBody final CustomerLegalEntitySaveRequest saveRequest) throws FunctionalException {
		return customerLegalEntityService.save(customerLegalEntityMapper.fromSaveRequestToEntity(saveRequest));
	}

	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Long> save(@RequestBody final List<CustomerLegalEntitySaveRequest> saveRequests) throws FunctionalException {
		ValidatorUtils.validateAll(saveRequests);
		return customerLegalEntityService.save(customerLegalEntityMapper.fromSaveRequestsToEntities(saveRequests));
	}

	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Long update(@Valid @RequestBody final CustomerLegalEntityUpdateRequest updateRequest) throws FunctionalException {
		return customerLegalEntityService.update(customerLegalEntityMapper.fromUpdateRequestToEntity(updateRequest));
	}

	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Long> update(@RequestBody final List<CustomerLegalEntityUpdateRequest> updateRequests) throws FunctionalException {
		ValidatorUtils.validateAll(updateRequests);
		return customerLegalEntityService.update(customerLegalEntityMapper.fromUpdateRequestsToEntities(updateRequests));
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable Long id) throws FunctionalException {
		customerLegalEntityService.delete(id);
		return new OkResponse();
	}

	@DeleteMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestBody List<Long> ids) throws FunctionalException {
		customerLegalEntityService.deleteMany(ids);
		return new OkResponse();
	}

}
