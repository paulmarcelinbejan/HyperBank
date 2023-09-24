package com.hyperbank.accounts.accountinternal.controller;

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

import com.hyperbank.accounts.accountinternal.dto.AccountInternalResponse;
import com.hyperbank.accounts.accountinternal.dto.AccountInternalSaveRequest;
import com.hyperbank.accounts.accountinternal.dto.AccountInternalUpdateRequest;
import com.hyperbank.accounts.accountinternal.mapper.AccountInternalMapper;
import com.hyperbank.accounts.accountinternal.service.AccountInternalService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;
import com.paulmarcelinbejan.toolbox.web.response.OkResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountInternalRestController {

	private final AccountInternalService accountInternalService;
	
	private final AccountInternalMapper accountInternalMapper;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody AccountInternalResponse findById(@PathVariable Long id) throws FunctionalException {
		return accountInternalMapper.toResponse(accountInternalService.findById(id));
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<AccountInternalResponse> findAll() {
		return accountInternalMapper.toResponses(accountInternalService.findAll());
	}

	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Long save(@Valid @RequestBody final AccountInternalSaveRequest saveRequest) throws FunctionalException {
		return accountInternalService.save(accountInternalMapper.fromSaveRequestToEntity(saveRequest));
	}

	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Long> save(@RequestBody final Collection<AccountInternalSaveRequest> saveRequests) throws FunctionalException {
		ValidatorUtils.validateAll(saveRequests);
		return accountInternalService.save(accountInternalMapper.fromSaveRequestsToEntities(saveRequests));
	}

	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Long update(@Valid @RequestBody final AccountInternalUpdateRequest updateRequest) throws FunctionalException {
		return accountInternalService.update(accountInternalMapper.fromUpdateRequestToEntity(updateRequest));
	}

	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Long> update(@RequestBody final Collection<AccountInternalUpdateRequest> updateRequests) throws FunctionalException {
		ValidatorUtils.validateAll(updateRequests);
		return accountInternalService.update(accountInternalMapper.fromUpdateRequestsToEntities(updateRequests));
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable Long id) throws FunctionalException {
		accountInternalService.delete(id);
		return new OkResponse();
	}

	@DeleteMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestBody Collection<Long> ids) throws FunctionalException {
		accountInternalService.deleteMany(ids);
		return new OkResponse();
	}

}
