package com.hyperbank.accounts.accountinternaltype.controller;

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

import com.hyperbank.accounts.accountinternaltype.dto.AccountInternalTypeDto;
import com.hyperbank.accounts.accountinternaltype.mapper.AccountInternalTypeMapper;
import com.hyperbank.accounts.accountinternaltype.service.AccountInternalTypeService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;
import com.paulmarcelinbejan.toolbox.web.response.OkResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/accountinternaltype")
public class AccountInternalTypeRestController {

	private final AccountInternalTypeService accountInternalTypeService;
	
	private final AccountInternalTypeMapper accountInternalTypeMapper;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody AccountInternalTypeDto findById(@PathVariable Integer id) throws FunctionalException {
		return accountInternalTypeMapper.toDto(accountInternalTypeService.findById(id));
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<AccountInternalTypeDto> findAll() {
		return accountInternalTypeMapper.toDtos(accountInternalTypeService.findAll());
	}

	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Integer save(@Validated(AccountInternalTypeDto.CreateValidation.class) @RequestBody final AccountInternalTypeDto dto) {
		return accountInternalTypeService.save(accountInternalTypeMapper.toEntity(dto));
	}

	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Integer> save(@RequestBody final Collection<AccountInternalTypeDto> dtos) {
		ValidatorUtils.validateGroups(dtos, AccountInternalTypeDto.CreateValidation.class);
		return accountInternalTypeService.save(accountInternalTypeMapper.toEntities(dtos));
	}

	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Integer update(@Validated(AccountInternalTypeDto.UpdateValidation.class) @RequestBody final AccountInternalTypeDto dto) throws FunctionalException {
		return accountInternalTypeService.update(accountInternalTypeMapper.toEntity(dto));
	}

	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Integer> update(@RequestBody final Collection<AccountInternalTypeDto> dtos) throws FunctionalException {
		ValidatorUtils.validateGroups(dtos, AccountInternalTypeDto.UpdateValidation.class);
		return accountInternalTypeService.update(accountInternalTypeMapper.toEntities(dtos));
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable Integer id) throws FunctionalException {
		accountInternalTypeService.delete(id);
		return new OkResponse();
	}

	@DeleteMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestBody Collection<Integer> ids) throws FunctionalException {
		accountInternalTypeService.deleteMany(ids);
		return new OkResponse();
	}

}
