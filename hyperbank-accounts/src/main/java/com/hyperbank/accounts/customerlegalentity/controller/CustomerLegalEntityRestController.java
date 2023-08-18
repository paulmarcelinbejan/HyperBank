package com.hyperbank.accounts.customerlegalentity.controller;

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

import com.hyperbank.accounts.customerlegalentity.dto.CustomerLegalEntityDto;
import com.hyperbank.accounts.customerlegalentity.mapper.CustomerLegalEntityMapper;
import com.hyperbank.accounts.customerlegalentity.service.CustomerLegalEntityService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;
import com.paulmarcelinbejan.toolbox.web.response.OkResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customerlegalentity")
public class CustomerLegalEntityRestController {

	private final CustomerLegalEntityService customerLegalEntityService;
	
	private final CustomerLegalEntityMapper customerLegalEntityMapper;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CustomerLegalEntityDto findById(@PathVariable Long id) throws FunctionalException {
		return customerLegalEntityMapper.toDto(customerLegalEntityService.findById(id));
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<CustomerLegalEntityDto> findAll() {
		return customerLegalEntityMapper.toDtos(customerLegalEntityService.findAll());
	}

	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Long save(@Validated(CustomerLegalEntityDto.CreateValidation.class) @RequestBody final CustomerLegalEntityDto dto) {
		return customerLegalEntityService.save(customerLegalEntityMapper.toEntity(dto));
	}

	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Long> save(@RequestBody final Collection<CustomerLegalEntityDto> dtos) {
		ValidatorUtils.validateGroups(dtos, CustomerLegalEntityDto.CreateValidation.class);
		return customerLegalEntityService.save(customerLegalEntityMapper.toEntities(dtos));
	}

	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Long update(@Validated(CustomerLegalEntityDto.UpdateValidation.class) @RequestBody final CustomerLegalEntityDto dto) throws FunctionalException {
		return customerLegalEntityService.update(customerLegalEntityMapper.toEntity(dto));
	}

	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Long> update(@RequestBody final Collection<CustomerLegalEntityDto> dtos) throws FunctionalException {
		ValidatorUtils.validateGroups(dtos, CustomerLegalEntityDto.UpdateValidation.class);
		return customerLegalEntityService.update(customerLegalEntityMapper.toEntities(dtos));
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable Long id) throws FunctionalException {
		customerLegalEntityService.delete(id);
		return new OkResponse();
	}

	@DeleteMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestBody Collection<Long> ids) throws FunctionalException {
		customerLegalEntityService.deleteMany(ids);
		return new OkResponse();
	}

}
