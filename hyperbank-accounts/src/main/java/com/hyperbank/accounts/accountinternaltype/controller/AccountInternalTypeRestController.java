package com.hyperbank.accounts.accountinternaltype.controller;

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

import com.hyperbank.accounts.accountinternaltype.dto.AccountInternalTypeResponse;
import com.hyperbank.accounts.accountinternaltype.dto.AccountInternalTypeSaveRequest;
import com.hyperbank.accounts.accountinternaltype.dto.AccountInternalTypeUpdateRequest;
import com.hyperbank.accounts.accountinternaltype.mapper.AccountInternalTypeMapper;
import com.hyperbank.accounts.accountinternaltype.service.AccountInternalTypeService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;
import com.paulmarcelinbejan.toolbox.web.response.OkResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/accountinternaltype")
public class AccountInternalTypeRestController {

	private final AccountInternalTypeService accountInternalTypeService;
	
	private final AccountInternalTypeMapper accountInternalTypeMapper;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody AccountInternalTypeResponse findById(@PathVariable Integer id) throws FunctionalException {
		return accountInternalTypeMapper.toResponse(accountInternalTypeService.findById(id));
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<AccountInternalTypeResponse> findAll() {
		return accountInternalTypeMapper.toResponses(accountInternalTypeService.findAll());
	}

	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Integer save(@Valid @RequestBody final AccountInternalTypeSaveRequest saveRequest) throws FunctionalException {
		return accountInternalTypeService.save(accountInternalTypeMapper.fromSaveRequestToEntity(saveRequest));
	}

	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Integer> save(@RequestBody final List<AccountInternalTypeSaveRequest> saveRequests) throws FunctionalException {
		ValidatorUtils.validateAll(saveRequests);
		return accountInternalTypeService.save(accountInternalTypeMapper.fromSaveRequestsToEntities(saveRequests));
	}

	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Integer update(@Valid @RequestBody final AccountInternalTypeUpdateRequest updateRequest) throws FunctionalException {
		return accountInternalTypeService.update(accountInternalTypeMapper.fromUpdateRequestToEntity(updateRequest));
	}

	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Integer> update(@RequestBody final List<AccountInternalTypeUpdateRequest> updateRequests) throws FunctionalException {
		ValidatorUtils.validateAll(updateRequests);
		return accountInternalTypeService.update(accountInternalTypeMapper.fromUpdateRequestsToEntities(updateRequests));
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable Integer id) throws FunctionalException {
		accountInternalTypeService.delete(id);
		return new OkResponse();
	}

	@DeleteMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestBody List<Integer> ids) throws FunctionalException {
		accountInternalTypeService.deleteMany(ids);
		return new OkResponse();
	}

}
