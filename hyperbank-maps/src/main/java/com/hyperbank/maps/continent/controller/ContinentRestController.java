package com.hyperbank.maps.continent.controller;

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

import com.hyperbank.maps.continent.api.delete.many.DeleteManyContinentCoordinator;
import com.hyperbank.maps.continent.api.delete.one.DeleteOneContinentCoordinator;
import com.hyperbank.maps.continent.api.find.all.FindAllContinentCoordinator;
import com.hyperbank.maps.continent.api.find.many.FindManyContinentCoordinator;
import com.hyperbank.maps.continent.api.find.one.FindOneContinentCoordinator;
import com.hyperbank.maps.continent.api.save.many.SaveManyContinentCoordinator;
import com.hyperbank.maps.continent.api.save.one.SaveOneContinentCoordinator;
import com.hyperbank.maps.continent.api.update.many.UpdateManyContinentCoordinator;
import com.hyperbank.maps.continent.api.update.one.UpdateOneContinentCoordinator;
import com.hyperbank.maps.continent.dto.ContinentResponse;
import com.hyperbank.maps.continent.dto.ContinentSaveRequest;
import com.hyperbank.maps.continent.dto.ContinentUpdateRequest;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import io.github.paulmarcelinbejan.toolbox.web.response.OkResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/continent")
public class ContinentRestController {

	private final SaveOneContinentCoordinator saveOneContinentCoordinator;
	
	private final SaveManyContinentCoordinator saveManyContinentCoordinator;
	
	private final FindOneContinentCoordinator findOneContinentCoordinator;
	
	private final FindManyContinentCoordinator findManyContinentCoordinator;
	
	private final FindAllContinentCoordinator findAllContinentCoordinator;
	
	private final UpdateOneContinentCoordinator updateOneContinentCoordinator;
	
	private final UpdateManyContinentCoordinator updateManyContinentCoordinator;
	
	private final DeleteOneContinentCoordinator deleteOneContinentCoordinator;
	
	private final DeleteManyContinentCoordinator deleteManyContinentCoordinator;
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ContinentResponse findById(@PathVariable Integer id) throws FunctionalException, TechnicalException {
		return findOneContinentCoordinator.process(id);
	}
	
	@GetMapping(value = "/find-many", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ContinentResponse> findMany(@RequestParam("id") List<Integer> ids) throws FunctionalException, TechnicalException {
		return findManyContinentCoordinator.process(ids);
	}
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ContinentResponse> findAll() throws FunctionalException, TechnicalException {
		return findAllContinentCoordinator.process();
	}
	
	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ContinentResponse save(@RequestBody final ContinentSaveRequest saveRequest) throws FunctionalException, TechnicalException {
		return saveOneContinentCoordinator.process(saveRequest);
	}
	
	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ContinentResponse> save(@RequestBody final List<ContinentSaveRequest> saveRequests) throws FunctionalException, TechnicalException {
		return saveManyContinentCoordinator.process(saveRequests);
	}
	
	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ContinentResponse update(@RequestBody final ContinentUpdateRequest updateRequest) throws FunctionalException, TechnicalException {
		return updateOneContinentCoordinator.process(updateRequest);
	}
	
	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ContinentResponse> update(@RequestBody final List<ContinentUpdateRequest> updateRequests) throws FunctionalException, TechnicalException {
		return updateManyContinentCoordinator.process(updateRequests);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable Integer id) throws FunctionalException, TechnicalException {
		deleteOneContinentCoordinator.process(id);
		return new OkResponse();
	}
	
	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestParam("id") List<Integer> ids) throws FunctionalException, TechnicalException {
		deleteManyContinentCoordinator.process(ids);
		return new OkResponse();
	}

}
