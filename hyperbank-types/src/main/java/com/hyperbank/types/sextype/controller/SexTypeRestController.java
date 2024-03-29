package com.hyperbank.types.sextype.controller;

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

import com.hyperbank.types.sextype.dto.SexTypeResponse;
import com.hyperbank.types.sextype.dto.SexTypeSaveRequest;
import com.hyperbank.types.sextype.dto.SexTypeUpdateRequest;
import com.hyperbank.types.sextype.mapper.SexTypeMapper;
import com.hyperbank.types.sextype.service.SexTypeService;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;
import io.github.paulmarcelinbejan.toolbox.web.response.OkResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sextype")
public class SexTypeRestController {

	private final SexTypeService sexTypeService;
	
	private final SexTypeMapper sexTypeMapper;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody SexTypeResponse findById(@PathVariable Integer id) throws FunctionalException {
		return sexTypeMapper.toResponse(sexTypeService.findById(id));
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<SexTypeResponse> findAll() {
		return sexTypeMapper.toResponses(sexTypeService.findAll());
	}

	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Integer save(@Valid @RequestBody final SexTypeSaveRequest saveRequest) throws FunctionalException {
		return sexTypeService.save(sexTypeMapper.fromSaveRequestToEntity(saveRequest));
	}

	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Integer> save(@RequestBody final List<SexTypeSaveRequest> saveRequests) throws FunctionalException {
		ValidatorUtils.validateAll(saveRequests);
		return sexTypeService.save(sexTypeMapper.fromSaveRequestsToEntities(saveRequests));
	}

	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Integer update(@Valid @RequestBody final SexTypeUpdateRequest updateRequest) throws FunctionalException {
		return sexTypeService.update(sexTypeMapper.fromUpdateRequestToEntity(updateRequest));
	}

	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Integer> update(@RequestBody final List<SexTypeUpdateRequest> updateRequests) throws FunctionalException {
		ValidatorUtils.validateAll(updateRequests);
		return sexTypeService.update(sexTypeMapper.fromUpdateRequestsToEntities(updateRequests));
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable Integer id) throws FunctionalException {
		sexTypeService.delete(id);
		return new OkResponse();
	}

	@DeleteMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestBody List<Integer> ids) throws FunctionalException {
		sexTypeService.deleteMany(ids);
		return new OkResponse();
	}

}
