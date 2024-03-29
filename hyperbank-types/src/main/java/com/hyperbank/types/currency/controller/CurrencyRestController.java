package com.hyperbank.types.currency.controller;

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

import com.hyperbank.types.currency.dto.CurrencyResponse;
import com.hyperbank.types.currency.dto.CurrencySaveRequest;
import com.hyperbank.types.currency.dto.CurrencyUpdateRequest;
import com.hyperbank.types.currency.mapper.CurrencyMapper;
import com.hyperbank.types.currency.service.CurrencyService;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;
import io.github.paulmarcelinbejan.toolbox.web.response.OkResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/currency")
public class CurrencyRestController {

	private final CurrencyService currencyService;
	
	private final CurrencyMapper currencyMapper;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CurrencyResponse findById(@PathVariable Integer id) throws FunctionalException {
		return currencyMapper.toResponse(currencyService.findById(id));
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CurrencyResponse> findAll() {
		return currencyMapper.toResponses(currencyService.findAll());
	}

	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Integer save(@Valid @RequestBody final CurrencySaveRequest saveRequest) throws FunctionalException {
		return currencyService.save(currencyMapper.fromSaveRequestToEntity(saveRequest));
	}

	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Integer> save(@RequestBody final List<CurrencySaveRequest> saveRequests) throws FunctionalException {
		ValidatorUtils.validateAll(saveRequests);
		return currencyService.save(currencyMapper.fromSaveRequestsToEntities(saveRequests));
	}

	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Integer update(@Valid @RequestBody final CurrencyUpdateRequest updateRequest) throws FunctionalException {
		return currencyService.update(currencyMapper.fromUpdateRequestToEntity(updateRequest));
	}

	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Integer> update(@RequestBody final List<CurrencyUpdateRequest> updateRequests) throws FunctionalException {
		ValidatorUtils.validateAll(updateRequests);
		return currencyService.update(currencyMapper.fromUpdateRequestsToEntities(updateRequests));
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable Integer id) throws FunctionalException {
		currencyService.delete(id);
		return new OkResponse();
	}

	@DeleteMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestBody List<Integer> ids) throws FunctionalException {
		currencyService.deleteMany(ids);
		return new OkResponse();
	}

}
