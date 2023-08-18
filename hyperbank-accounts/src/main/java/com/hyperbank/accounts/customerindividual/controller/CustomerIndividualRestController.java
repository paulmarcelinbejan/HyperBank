package com.hyperbank.accounts.customerindividual.controller;

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

import com.hyperbank.accounts.customerindividual.dto.CustomerIndividualDto;
import com.hyperbank.accounts.customerindividual.mapper.CustomerIndividualMapper;
import com.hyperbank.accounts.customerindividual.service.CustomerIndividualService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;
import com.paulmarcelinbejan.toolbox.web.response.OkResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customerindividual")
public class CustomerIndividualRestController {

	private final CustomerIndividualService customerIndividualService;
	
	private final CustomerIndividualMapper customerIndividualMapper;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CustomerIndividualDto findById(@PathVariable Long id) throws FunctionalException {
		return customerIndividualMapper.toDto(customerIndividualService.findById(id));
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<CustomerIndividualDto> findAll() {
		return customerIndividualMapper.toDtos(customerIndividualService.findAll());
	}

	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Long save(@Validated(CustomerIndividualDto.CreateValidation.class) @RequestBody final CustomerIndividualDto dto) {
		return customerIndividualService.save(customerIndividualMapper.toEntity(dto));
	}

	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Long> save(@RequestBody final Collection<CustomerIndividualDto> dtos) {
		ValidatorUtils.validateGroups(dtos, CustomerIndividualDto.CreateValidation.class);
		return customerIndividualService.save(customerIndividualMapper.toEntities(dtos));
	}

	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Long update(@Validated(CustomerIndividualDto.UpdateValidation.class) @RequestBody final CustomerIndividualDto dto) throws FunctionalException {
		return customerIndividualService.update(customerIndividualMapper.toEntity(dto));
	}

	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Long> update(@RequestBody final Collection<CustomerIndividualDto> dtos) throws FunctionalException {
		ValidatorUtils.validateGroups(dtos, CustomerIndividualDto.UpdateValidation.class);
		return customerIndividualService.update(customerIndividualMapper.toEntities(dtos));
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable Long id) throws FunctionalException {
		customerIndividualService.delete(id);
		return new OkResponse();
	}

	@DeleteMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestBody Collection<Long> ids) throws FunctionalException {
		customerIndividualService.deleteMany(ids);
		return new OkResponse();
	}

}
