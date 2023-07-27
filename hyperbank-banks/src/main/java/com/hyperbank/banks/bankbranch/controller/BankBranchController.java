package com.hyperbank.banks.bankbranch.controller;

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

import com.hyperbank.banks.bankbranch.dto.BankBranchDto;
import com.hyperbank.banks.bankbranch.service.BankBranchService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;
import com.paulmarcelinbejan.toolbox.web.response.OkResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bankbranch")
public class BankBranchController {

	private final BankBranchService bankBranchService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BankBranchDto findById(@PathVariable Integer id) throws FunctionalException {
		return bankBranchService.findByIdToDto(id);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<BankBranchDto> findAll() {
		return bankBranchService.findAllToDto();
	}

	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Integer
			save(@Validated(BankBranchDto.CreateValidation.class) @RequestBody final BankBranchDto dto)
					throws TechnicalException {
		return bankBranchService.save(dto);
	}

	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Integer> save(@RequestBody final Collection<BankBranchDto> dtos)
			throws TechnicalException {
		ValidatorUtils.validateGroups(dtos, BankBranchDto.CreateValidation.class);
		return bankBranchService.save(dtos);
	}

	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Integer
			update(@Validated(BankBranchDto.UpdateValidation.class) @RequestBody final BankBranchDto dto)
					throws FunctionalException, TechnicalException {
		return bankBranchService.update(dto);
	}

	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Integer> update(@RequestBody final Collection<BankBranchDto> dtos)
			throws FunctionalException, TechnicalException {
		ValidatorUtils.validateGroups(dtos, BankBranchDto.UpdateValidation.class);
		return bankBranchService.update(dtos);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable Integer id) throws FunctionalException {
		bankBranchService.delete(id);
		return new OkResponse();
	}

	@DeleteMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestBody Collection<Integer> ids) throws FunctionalException {
		bankBranchService.delete(ids);
		return new OkResponse();
	}

}
