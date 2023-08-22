//package com.hyperbank.commons.currency.controller;
//
//import java.util.Collection;
//
//import org.springframework.http.MediaType;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.hyperbank.commons.currency.dto.CurrencyDto;
//import com.hyperbank.commons.currency.mapper.CurrencyMapper;
//import com.hyperbank.commons.currency.service.CurrencyService;
//import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
//import com.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;
//import com.paulmarcelinbejan.toolbox.web.response.OkResponse;
//
//import lombok.RequiredArgsConstructor;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/currency")
//public class CurrencyRestController {
//
//	private final CurrencyService currencyService;
//	
//	private final CurrencyMapper currencyMapper;
//
//	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody CurrencyDto findById(@PathVariable Integer id) throws FunctionalException {
//		return currencyMapper.toDto(currencyService.findById(id));
//	}
//
//	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody Collection<CurrencyDto> findAll() {
//		return currencyMapper.toDtos(currencyService.findAll());
//	}
//
//	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody Integer save(@Validated(CurrencyDto.CreateValidation.class) @RequestBody final CurrencyDto dto) {
//		return currencyService.save(currencyMapper.toEntity(dto));
//	}
//
//	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody Collection<Integer> save(@RequestBody final Collection<CurrencyDto> dtos) {
//		ValidatorUtils.validateGroups(dtos, CurrencyDto.CreateValidation.class);
//		return currencyService.save(currencyMapper.toEntities(dtos));
//	}
//
//	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody Integer update(@Validated(CurrencyDto.UpdateValidation.class) @RequestBody final CurrencyDto dto) throws FunctionalException {
//		return currencyService.update(currencyMapper.toEntity(dto));
//	}
//
//	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody Collection<Integer> update(@RequestBody final Collection<CurrencyDto> dtos) throws FunctionalException {
//		ValidatorUtils.validateGroups(dtos, CurrencyDto.UpdateValidation.class);
//		return currencyService.update(currencyMapper.toEntities(dtos));
//	}
//
//	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody OkResponse delete(@PathVariable Integer id) throws FunctionalException {
//		currencyService.delete(id);
//		return new OkResponse();
//	}
//
//	@DeleteMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody OkResponse delete(@RequestBody Collection<Integer> ids) throws FunctionalException {
//		currencyService.deleteMany(ids);
//		return new OkResponse();
//	}
//
//}
