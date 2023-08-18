package com.hyperbank.accounts.accountinternal.controller;

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

import com.hyperbank.accounts.accountinternal.dto.AccountInternalDto;
import com.hyperbank.accounts.accountinternal.mapper.AccountInternalMapper;
import com.hyperbank.accounts.accountinternal.service.AccountInternalService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;
import com.paulmarcelinbejan.toolbox.web.response.OkResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountInternalRestController {

	private final AccountInternalService accountInternalService;
	
	private final AccountInternalMapper accountInternalMapper;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody AccountInternalDto findById(@PathVariable Long id) throws FunctionalException {
		return accountInternalMapper.toDto(accountInternalService.findById(id));
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<AccountInternalDto> findAll() {
		return accountInternalMapper.toDtos(accountInternalService.findAll());
	}

	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Long save(@Validated(AccountInternalDto.CreateValidation.class) @RequestBody final AccountInternalDto dto) {
		return accountInternalService.save(accountInternalMapper.toEntity(dto));
	}

	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Long> save(@RequestBody final Collection<AccountInternalDto> dtos) {
		ValidatorUtils.validateGroups(dtos, AccountInternalDto.CreateValidation.class);
		return accountInternalService.save(accountInternalMapper.toEntities(dtos));
	}

	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Long update(@Validated(AccountInternalDto.UpdateValidation.class) @RequestBody final AccountInternalDto dto) throws FunctionalException {
		return accountInternalService.update(accountInternalMapper.toEntity(dto));
	}

	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Long> update(@RequestBody final Collection<AccountInternalDto> dtos) throws FunctionalException {
		ValidatorUtils.validateGroups(dtos, AccountInternalDto.UpdateValidation.class);
		return accountInternalService.update(accountInternalMapper.toEntities(dtos));
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
