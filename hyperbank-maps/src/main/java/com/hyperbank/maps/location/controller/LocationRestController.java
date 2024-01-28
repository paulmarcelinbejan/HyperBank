package com.hyperbank.maps.location.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyperbank.maps.location.api.delete.many.DeleteManyLocationCoordinator;
import com.hyperbank.maps.location.api.delete.one.DeleteOneLocationCoordinator;
import com.hyperbank.maps.location.api.find.all.FindAllLocationCoordinator;
import com.hyperbank.maps.location.api.find.many.FindManyLocationCoordinator;
import com.hyperbank.maps.location.api.find.one.FindOneLocationCoordinator;
import com.hyperbank.maps.location.api.save.many.SaveManyLocationCoordinator;
import com.hyperbank.maps.location.api.save.one.SaveOneLocationCoordinator;
import com.hyperbank.maps.location.api.update.many.UpdateManyLocationCoordinator;
import com.hyperbank.maps.location.api.update.one.UpdateOneLocationCoordinator;
import com.hyperbank.maps.location.dto.LocationResponse;
import com.hyperbank.maps.location.dto.LocationSaveRequest;
import com.hyperbank.maps.location.dto.LocationUpdateRequest;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import io.github.paulmarcelinbejan.toolbox.web.response.OkResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/location")
public class LocationRestController {

	private final SaveOneLocationCoordinator saveOneLocationCoordinator;
	
	private final SaveManyLocationCoordinator saveManyLocationCoordinator;
	
	private final FindOneLocationCoordinator findOneLocationCoordinator;
	
	private final FindManyLocationCoordinator findManyLocationCoordinator;
	
	private final FindAllLocationCoordinator findAllLocationCoordinator;
	
	private final UpdateOneLocationCoordinator updateOneLocationCoordinator;
	
	private final UpdateManyLocationCoordinator updateManyLocationCoordinator;
	
	private final DeleteOneLocationCoordinator deleteOneLocationCoordinator;
	
	private final DeleteManyLocationCoordinator deleteManyLocationCoordinator;
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody LocationResponse findById(@PathVariable Long id) throws FunctionalException, TechnicalException {
		return findOneLocationCoordinator.process(id);
	}
	
	@GetMapping(value = "/find-many", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<LocationResponse> findMany(@RequestParam("id") List<Long> ids) throws FunctionalException, TechnicalException {
		return findManyLocationCoordinator.process(ids);
	}
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<LocationResponse> findAll() throws FunctionalException, TechnicalException {
		return findAllLocationCoordinator.process();
	}
	
	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody LocationResponse save(@RequestBody final LocationSaveRequest saveRequest) throws FunctionalException, TechnicalException {
		return saveOneLocationCoordinator.process(saveRequest);
	}
	
	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<LocationResponse> save(@RequestBody final List<LocationSaveRequest> saveRequests) throws FunctionalException, TechnicalException {
		return saveManyLocationCoordinator.process(saveRequests);
	}
	
	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody LocationResponse update(@RequestBody final LocationUpdateRequest updateRequest) throws FunctionalException, TechnicalException {
		return updateOneLocationCoordinator.process(updateRequest);
	}
	
	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<LocationResponse> update(@RequestBody final List<LocationUpdateRequest> updateRequests) throws FunctionalException, TechnicalException {
		return updateManyLocationCoordinator.process(updateRequests);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable Long id) throws FunctionalException, TechnicalException {
		deleteOneLocationCoordinator.process(id);
		return new OkResponse();
	}
	
	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestParam("id") List<Long> ids) throws FunctionalException, TechnicalException {
		deleteManyLocationCoordinator.process(ids);
		return new OkResponse();
	}

}
