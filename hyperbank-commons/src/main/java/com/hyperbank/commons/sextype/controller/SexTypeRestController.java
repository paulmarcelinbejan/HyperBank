//package com.hyperbank.commons.sextype.controller;
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
//import com.hyperbank.commons.sextype.dto.SexTypeDto;
//import com.hyperbank.commons.sextype.mapper.SexTypeMapper;
//import com.hyperbank.commons.sextype.service.SexTypeService;
//import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
//import com.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;
//import com.paulmarcelinbejan.toolbox.web.response.OkResponse;
//
//import lombok.RequiredArgsConstructor;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/sextype")
//public class SexTypeRestController {
//
//	private final SexTypeService sexTypeService;
//	
//	private final SexTypeMapper sexTypeMapper;
//
//	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody SexTypeDto findById(@PathVariable Integer id) throws FunctionalException {
//		return sexTypeMapper.toDto(sexTypeService.findById(id));
//	}
//
//	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody Collection<SexTypeDto> findAll() {
//		return sexTypeMapper.toDtos(sexTypeService.findAll());
//	}
//
//	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody Integer save(@Validated(SexTypeDto.CreateValidation.class) @RequestBody final SexTypeDto dto) {
//		return sexTypeService.save(sexTypeMapper.toEntity(dto));
//	}
//
//	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody Collection<Integer> save(@RequestBody final Collection<SexTypeDto> dtos) {
//		ValidatorUtils.validateGroups(dtos, SexTypeDto.CreateValidation.class);
//		return sexTypeService.save(sexTypeMapper.toEntities(dtos));
//	}
//
//	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody Integer update(@Validated(SexTypeDto.UpdateValidation.class) @RequestBody final SexTypeDto dto) throws FunctionalException {
//		return sexTypeService.update(sexTypeMapper.toEntity(dto));
//	}
//
//	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody Collection<Integer> update(@RequestBody final Collection<SexTypeDto> dtos) throws FunctionalException {
//		ValidatorUtils.validateGroups(dtos, SexTypeDto.UpdateValidation.class);
//		return sexTypeService.update(sexTypeMapper.toEntities(dtos));
//	}
//
//	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody OkResponse delete(@PathVariable Integer id) throws FunctionalException {
//		sexTypeService.delete(id);
//		return new OkResponse();
//	}
//
//	@DeleteMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody OkResponse delete(@RequestBody Collection<Integer> ids) throws FunctionalException {
//		sexTypeService.deleteMany(ids);
//		return new OkResponse();
//	}
//
//}
