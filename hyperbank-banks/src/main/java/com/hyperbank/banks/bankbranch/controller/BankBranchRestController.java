package com.hyperbank.banks.bankbranch.controller;

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

import com.hyperbank.banks.bankbranch.dto.BankBranchResponse;
import com.hyperbank.banks.bankbranch.dto.BankBranchSaveRequest;
import com.hyperbank.banks.bankbranch.dto.BankBranchUpdateRequest;
import com.hyperbank.banks.bankbranch.mapper.BankBranchMapper;
import com.hyperbank.banks.bankbranch.service.BankBranchService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;
import com.paulmarcelinbejan.toolbox.web.response.OkResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bankbranch")
public class BankBranchRestController {

	private final BankBranchService bankBranchService;
	
	private final BankBranchMapper bankBranchMapper;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BankBranchResponse findById(@PathVariable Integer id) throws FunctionalException {
		return bankBranchMapper.toResponse(bankBranchService.findById(id));
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<BankBranchResponse> findAll() {
		return bankBranchMapper.toResponses(bankBranchService.findAll());
	}

	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Integer save(@Valid @RequestBody final BankBranchSaveRequest saveRequest) throws FunctionalException {
		return bankBranchService.save(bankBranchMapper.fromSaveRequestToEntity(saveRequest));
	}

	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Integer> save(@RequestBody final List<BankBranchSaveRequest> saveRequests) throws FunctionalException {
		ValidatorUtils.validateAll(saveRequests);
		return bankBranchService.save(bankBranchMapper.fromSaveRequestsToEntities(saveRequests));
	}

	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Integer update(@Valid @RequestBody final BankBranchUpdateRequest updateRequest) throws FunctionalException {
		return bankBranchService.update(bankBranchMapper.fromUpdateRequestToEntity(updateRequest));
	}

	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Integer> update(@RequestBody final List<BankBranchUpdateRequest> updateRequests) throws FunctionalException {
		ValidatorUtils.validateAll(updateRequests);
		return bankBranchService.update(bankBranchMapper.fromUpdateRequestsToEntities(updateRequests));
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable Integer id) throws FunctionalException {
		bankBranchService.delete(id);
		return new OkResponse();
	}

	@DeleteMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestBody List<Integer> ids) throws FunctionalException {
		bankBranchService.deleteMany(ids);
		return new OkResponse();
	}

}
