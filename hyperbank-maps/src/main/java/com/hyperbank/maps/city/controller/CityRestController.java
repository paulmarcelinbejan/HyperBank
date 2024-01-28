package com.hyperbank.maps.city.controller;

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

import com.hyperbank.maps.city.api.delete.many.DeleteManyCityCoordinator;
import com.hyperbank.maps.city.api.delete.one.DeleteOneCityCoordinator;
import com.hyperbank.maps.city.api.find.all.FindAllCityCoordinator;
import com.hyperbank.maps.city.api.find.many.FindManyCityCoordinator;
import com.hyperbank.maps.city.api.find.one.FindOneCityCoordinator;
import com.hyperbank.maps.city.api.save.many.SaveManyCityCoordinator;
import com.hyperbank.maps.city.api.save.one.SaveOneCityCoordinator;
import com.hyperbank.maps.city.api.update.many.UpdateManyCityCoordinator;
import com.hyperbank.maps.city.api.update.one.UpdateOneCityCoordinator;
import com.hyperbank.maps.city.dto.CityResponse;
import com.hyperbank.maps.city.dto.CitySaveRequest;
import com.hyperbank.maps.city.dto.CityUpdateRequest;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import io.github.paulmarcelinbejan.toolbox.web.response.OkResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/city")
public class CityRestController {

	private final SaveOneCityCoordinator saveOneCityCoordinator;
	
	private final SaveManyCityCoordinator saveManyCityCoordinator;
	
	private final FindOneCityCoordinator findOneCityCoordinator;
	
	private final FindManyCityCoordinator findManyCityCoordinator;
	
	private final FindAllCityCoordinator findAllCityCoordinator;
	
	private final UpdateOneCityCoordinator updateOneCityCoordinator;
	
	private final UpdateManyCityCoordinator updateManyCityCoordinator;
	
	private final DeleteOneCityCoordinator deleteOneCityCoordinator;
	
	private final DeleteManyCityCoordinator deleteManyCityCoordinator;
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CityResponse findById(@PathVariable Integer id) throws FunctionalException, TechnicalException {
		return findOneCityCoordinator.process(id);
	}
	
	@GetMapping(value = "/find-many", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CityResponse> findMany(@RequestParam("id") List<Integer> ids) throws FunctionalException, TechnicalException {
		return findManyCityCoordinator.process(ids);
	}
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CityResponse> findAll() throws FunctionalException, TechnicalException {
		return findAllCityCoordinator.process();
	}
	
	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CityResponse save(@RequestBody final CitySaveRequest saveRequest) throws FunctionalException, TechnicalException {
		return saveOneCityCoordinator.process(saveRequest);
	}
	
	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CityResponse> save(@RequestBody final List<CitySaveRequest> saveRequests) throws FunctionalException, TechnicalException {
		return saveManyCityCoordinator.process(saveRequests);
	}
	
	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CityResponse update(@RequestBody final CityUpdateRequest updateRequest) throws FunctionalException, TechnicalException {
		return updateOneCityCoordinator.process(updateRequest);
	}
	
	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CityResponse> update(@RequestBody final List<CityUpdateRequest> updateRequests) throws FunctionalException, TechnicalException {
		return updateManyCityCoordinator.process(updateRequests);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable Integer id) throws FunctionalException, TechnicalException {
		deleteOneCityCoordinator.process(id);
		return new OkResponse();
	}
	
	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestParam("id") List<Integer> ids) throws FunctionalException, TechnicalException {
		deleteManyCityCoordinator.process(ids);
		return new OkResponse();
	}

}
