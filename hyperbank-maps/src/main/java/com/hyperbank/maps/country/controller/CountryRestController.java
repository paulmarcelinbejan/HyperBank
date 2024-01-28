package com.hyperbank.maps.country.controller;

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

import com.hyperbank.maps.country.api.delete.many.DeleteManyCountryCoordinator;
import com.hyperbank.maps.country.api.delete.one.DeleteOneCountryCoordinator;
import com.hyperbank.maps.country.api.find.all.FindAllCountryCoordinator;
import com.hyperbank.maps.country.api.find.many.FindManyCountryCoordinator;
import com.hyperbank.maps.country.api.find.one.FindOneCountryCoordinator;
import com.hyperbank.maps.country.api.save.many.SaveManyCountryCoordinator;
import com.hyperbank.maps.country.api.save.one.SaveOneCountryCoordinator;
import com.hyperbank.maps.country.api.update.many.UpdateManyCountryCoordinator;
import com.hyperbank.maps.country.api.update.one.UpdateOneCountryCoordinator;
import com.hyperbank.maps.country.dto.CountryResponse;
import com.hyperbank.maps.country.dto.CountrySaveRequest;
import com.hyperbank.maps.country.dto.CountryUpdateRequest;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import io.github.paulmarcelinbejan.toolbox.web.response.OkResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/country")
public class CountryRestController {

	private final SaveOneCountryCoordinator saveOneCountryCoordinator;
	
	private final SaveManyCountryCoordinator saveManyCountryCoordinator;
	
	private final FindOneCountryCoordinator findOneCountryCoordinator;
	
	private final FindManyCountryCoordinator findManyCountryCoordinator;
	
	private final FindAllCountryCoordinator findAllCountryCoordinator;
	
	private final UpdateOneCountryCoordinator updateOneCountryCoordinator;
	
	private final UpdateManyCountryCoordinator updateManyCountryCoordinator;
	
	private final DeleteOneCountryCoordinator deleteOneCountryCoordinator;
	
	private final DeleteManyCountryCoordinator deleteManyCountryCoordinator;
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CountryResponse findById(@PathVariable Integer id) throws FunctionalException, TechnicalException {
		return findOneCountryCoordinator.process(id);
	}
	
	@GetMapping(value = "/find-many", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CountryResponse> findMany(@RequestParam("id") List<Integer> ids) throws FunctionalException, TechnicalException {
		return findManyCountryCoordinator.process(ids);
	}
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CountryResponse> findAll() throws FunctionalException, TechnicalException {
		return findAllCountryCoordinator.process();
	}
	
	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CountryResponse save(@RequestBody final CountrySaveRequest saveRequest) throws FunctionalException, TechnicalException {
		return saveOneCountryCoordinator.process(saveRequest);
	}
	
	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CountryResponse> save(@RequestBody final List<CountrySaveRequest> saveRequests) throws FunctionalException, TechnicalException {
		return saveManyCountryCoordinator.process(saveRequests);
	}
	
	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CountryResponse update(@RequestBody final CountryUpdateRequest updateRequest) throws FunctionalException, TechnicalException {
		return updateOneCountryCoordinator.process(updateRequest);
	}
	
	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CountryResponse> update(@RequestBody final List<CountryUpdateRequest> updateRequests) throws FunctionalException, TechnicalException {
		return updateManyCountryCoordinator.process(updateRequests);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable Integer id) throws FunctionalException, TechnicalException {
		deleteOneCountryCoordinator.process(id);
		return new OkResponse();
	}
	
	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestParam("id") List<Integer> ids) throws FunctionalException, TechnicalException {
		deleteManyCountryCoordinator.process(ids);
		return new OkResponse();
	}

}
