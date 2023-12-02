package com.hyperbank.staff.employee.controller;

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

import com.hyperbank.staff.employee.api.delete.many.DeleteManyEmployeeCoordinator;
import com.hyperbank.staff.employee.api.delete.one.DeleteOneEmployeeCoordinator;
import com.hyperbank.staff.employee.api.find.all.FindAllEmployeeCoordinator;
import com.hyperbank.staff.employee.api.find.many.FindManyEmployeeCoordinator;
import com.hyperbank.staff.employee.api.find.one.FindOneEmployeeCoordinator;
import com.hyperbank.staff.employee.api.save.many.SaveManyEmployeeCoordinator;
import com.hyperbank.staff.employee.api.save.one.SaveOneEmployeeCoordinator;
import com.hyperbank.staff.employee.api.update.many.UpdateManyEmployeeCoordinator;
import com.hyperbank.staff.employee.api.update.one.UpdateOneEmployeeCoordinator;
import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.hyperbank.staff.employee.dto.EmployeeUpdateRequest;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.web.response.OkResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeRestController {

	private final SaveOneEmployeeCoordinator saveOneEmployeeCoordinator;
	
	private final SaveManyEmployeeCoordinator saveManyEmployeeCoordinator;
	
	private final FindOneEmployeeCoordinator findOneEmployeeCoordinator;
	
	private final FindManyEmployeeCoordinator findManyEmployeeCoordinator;
	
	private final FindAllEmployeeCoordinator findAllEmployeeCoordinator;
	
	private final UpdateOneEmployeeCoordinator updateOneEmployeeCoordinator;
	
	private final UpdateManyEmployeeCoordinator updateManyEmployeeCoordinator;
	
	private final DeleteOneEmployeeCoordinator deleteOneEmployeeCoordinator;
	
	private final DeleteManyEmployeeCoordinator deleteManyEmployeeCoordinator;
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody EmployeeResponse findById(@PathVariable Long id) throws FunctionalException, TechnicalException {
		return findOneEmployeeCoordinator.process(id);
	}
	
	@GetMapping(value = "/find-many", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<EmployeeResponse> findMany(@RequestParam("id") List<Long> ids) throws FunctionalException, TechnicalException {
		return findManyEmployeeCoordinator.process(ids);
	}
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<EmployeeResponse> findAll() throws FunctionalException, TechnicalException {
		return findAllEmployeeCoordinator.process();
	}
	
	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody EmployeeResponse save(@RequestBody final EmployeeSaveRequest saveRequest) throws FunctionalException, TechnicalException {
		return saveOneEmployeeCoordinator.process(saveRequest);
	}
	
	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<EmployeeResponse> save(@RequestBody final List<EmployeeSaveRequest> saveRequests) throws FunctionalException, TechnicalException {
		return saveManyEmployeeCoordinator.process(saveRequests);
	}
	
	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody EmployeeResponse update(@RequestBody final EmployeeUpdateRequest updateRequest) throws FunctionalException, TechnicalException {
		return updateOneEmployeeCoordinator.process(updateRequest);
	}
	
	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<EmployeeResponse> update(@RequestBody final List<EmployeeUpdateRequest> updateRequests) throws FunctionalException, TechnicalException {
		return updateManyEmployeeCoordinator.process(updateRequests);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable Long id) throws FunctionalException, TechnicalException {
		deleteOneEmployeeCoordinator.process(id);
		return new OkResponse();
	}
	
	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestParam("id") List<Long> ids) throws FunctionalException, TechnicalException {
		deleteManyEmployeeCoordinator.process(ids);
		return new OkResponse();
	}

}
