package com.hyperbank.accounts.customerindividual.controller;

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

import com.hyperbank.accounts.customerindividual.dto.CustomerIndividualResponse;
import com.hyperbank.accounts.customerindividual.dto.CustomerIndividualSaveRequest;
import com.hyperbank.accounts.customerindividual.dto.CustomerIndividualUpdateRequest;
import com.hyperbank.accounts.customerindividual.mapper.CustomerIndividualMapper;
import com.hyperbank.accounts.customerindividual.service.CustomerIndividualService;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;
import io.github.paulmarcelinbejan.toolbox.web.response.OkResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customerindividual")
public class CustomerIndividualRestController {

	private final CustomerIndividualService customerIndividualService;
	
	private final CustomerIndividualMapper customerIndividualMapper;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CustomerIndividualResponse findById(@PathVariable Long id) throws FunctionalException {
		return customerIndividualMapper.toResponse(customerIndividualService.findById(id));
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CustomerIndividualResponse> findAll() {
		return customerIndividualMapper.toResponses(customerIndividualService.findAll());
	}

	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Long save(@Valid @RequestBody final CustomerIndividualSaveRequest saveRequest) throws FunctionalException {
		return customerIndividualService.save(customerIndividualMapper.fromSaveRequestToEntity(saveRequest));
	}

	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Long> save(@RequestBody final List<CustomerIndividualSaveRequest> saveRequests) throws FunctionalException {
		ValidatorUtils.validateAll(saveRequests);
		return customerIndividualService.save(customerIndividualMapper.fromSaveRequestsToEntities(saveRequests));
	}

	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Long update(@Valid @RequestBody final CustomerIndividualUpdateRequest updateRequest) throws FunctionalException {
		return customerIndividualService.update(customerIndividualMapper.fromUpdateRequestToEntity(updateRequest));
	}

	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Long> update(@RequestBody final List<CustomerIndividualUpdateRequest> updateRequests) throws FunctionalException {
		ValidatorUtils.validateAll(updateRequests);
		return customerIndividualService.update(customerIndividualMapper.fromUpdateRequestsToEntities(updateRequests));
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable Long id) throws FunctionalException {
		customerIndividualService.delete(id);
		return new OkResponse();
	}

	@DeleteMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestBody List<Long> ids) throws FunctionalException {
		customerIndividualService.deleteMany(ids);
		return new OkResponse();
	}

}
