package com.hyperbank.accounts.depositaccountdetails.controller;

import java.util.Collection;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyperbank.accounts.depositaccountdetails.dto.DepositAccountResponse;
import com.hyperbank.accounts.depositaccountdetails.mapper.DepositAccountDetailsMapper;
import com.hyperbank.accounts.depositaccountdetails.service.DepositAccountDetailsService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.web.response.OkResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/depositaccountdetails")
public class DepositAccountDetailsRestController {

	private final DepositAccountDetailsService depositAccountDetailsService;
	
	private final DepositAccountDetailsMapper depositAccountDetailsMapper;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody DepositAccountResponse findById(@PathVariable Long id) throws FunctionalException {
		return depositAccountDetailsMapper.toResponse(depositAccountDetailsService.findById(id));
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<DepositAccountResponse> findAll() {
		return depositAccountDetailsMapper.toResponses(depositAccountDetailsService.findAll());
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable Long id) throws FunctionalException {
		depositAccountDetailsService.delete(id);
		return new OkResponse();
	}

	@DeleteMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestBody Collection<Long> ids) throws FunctionalException {
		depositAccountDetailsService.deleteMany(ids);
		return new OkResponse();
	}

}
