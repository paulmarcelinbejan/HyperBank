package com.hyperbank.accounts.accountnotification.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyperbank.accounts.accountnotification.dto.AccountNotificationResponse;
import com.hyperbank.accounts.accountnotification.dto.AccountNotificationSaveRequest;
import com.hyperbank.accounts.accountnotification.mapper.AccountNotificationMapper;
import com.hyperbank.accounts.accountnotification.service.AccountNotificationService;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;
import io.github.paulmarcelinbejan.toolbox.web.response.OkResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/accountnotification")
public class AccountNotificationRestController {

	private final AccountNotificationService accountNotificationService;
	
	private final AccountNotificationMapper accountNotificationMapper;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody AccountNotificationResponse findById(@PathVariable Long id) throws FunctionalException {
		return accountNotificationMapper.toResponse(accountNotificationService.findById(id));
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<AccountNotificationResponse> findAll() {
		return accountNotificationMapper.toResponses(accountNotificationService.findAll());
	}

	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Long save(@Valid @RequestBody final AccountNotificationSaveRequest saveRequest) throws FunctionalException {
		return accountNotificationService.save(accountNotificationMapper.fromSaveRequestToEntity(saveRequest));
	}

	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Long> save(@RequestBody final List<AccountNotificationSaveRequest> saveRequests) throws FunctionalException {
		ValidatorUtils.validateAll(saveRequests);
		return accountNotificationService.save(accountNotificationMapper.fromSaveRequestsToEntities(saveRequests));
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable Long id) throws FunctionalException {
		accountNotificationService.delete(id);
		return new OkResponse();
	}

	@DeleteMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestBody List<Long> ids) throws FunctionalException {
		accountNotificationService.deleteMany(ids);
		return new OkResponse();
	}

}
