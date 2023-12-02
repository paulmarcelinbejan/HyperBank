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

import com.hyperbank.staff.employee.api.delete.many.EmployeeDeleteManyCoordinator;
import com.hyperbank.staff.employee.api.delete.one.EmployeeDeleteOneCoordinator;
import com.hyperbank.staff.employee.api.find.all.EmployeeFindAllCoordinator;
import com.hyperbank.staff.employee.api.find.many.EmployeeFindManyCoordinator;
import com.hyperbank.staff.employee.api.find.one.EmployeeFindOneCoordinator;
import com.hyperbank.staff.employee.api.save.many.EmployeeSaveManyCoordinator;
import com.hyperbank.staff.employee.api.save.one.EmployeeSaveOneCoordinator;
import com.hyperbank.staff.employee.api.update.many.EmployeeUpdateManyCoordinator;
import com.hyperbank.staff.employee.api.update.one.EmployeeUpdateOneCoordinator;
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

	private final EmployeeSaveOneCoordinator employeeSaveOneCoordinator;
	
	private final EmployeeSaveManyCoordinator employeeSaveManyCoordinator;
	
	private final EmployeeFindOneCoordinator employeeFindOneCoordinator;
	
	private final EmployeeFindManyCoordinator employeeFindManyCoordinator;
	
	private final EmployeeFindAllCoordinator employeeFindAllCoordinator;
	
	private final EmployeeUpdateOneCoordinator employeeUpdateOneCoordinator;
	
	private final EmployeeUpdateManyCoordinator employeeUpdateManyCoordinator;
	
	private final EmployeeDeleteOneCoordinator employeeDeleteOneCoordinator;
	
	private final EmployeeDeleteManyCoordinator employeeDeleteManyCoordinator;
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody EmployeeResponse findById(@PathVariable Long id) throws FunctionalException, TechnicalException {
		return employeeFindOneCoordinator.process(id);
	}

	@GetMapping(value = "/find-many", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<EmployeeResponse> findMany(@RequestParam List<Long> ids) throws FunctionalException, TechnicalException {
		return employeeFindManyCoordinator.process(ids);
	}
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<EmployeeResponse> findAll() throws FunctionalException, TechnicalException {
		return employeeFindAllCoordinator.process();
	}

	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody EmployeeResponse save(@RequestBody final EmployeeSaveRequest saveRequest) throws FunctionalException, TechnicalException {
		return employeeSaveOneCoordinator.process(saveRequest);
	}

	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<EmployeeResponse> save(@RequestBody final List<EmployeeSaveRequest> saveRequests) throws FunctionalException, TechnicalException {
		return employeeSaveManyCoordinator.process(saveRequests);
	}

	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody EmployeeResponse update(@RequestBody final EmployeeUpdateRequest updateRequest) throws FunctionalException, TechnicalException {
		return employeeUpdateOneCoordinator.process(updateRequest);
	}

	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<EmployeeResponse> update(@RequestBody final List<EmployeeUpdateRequest> updateRequests) throws FunctionalException, TechnicalException {
		return employeeUpdateManyCoordinator.process(updateRequests);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable Long id) throws FunctionalException, TechnicalException {
		employeeDeleteOneCoordinator.process(id);
		return new OkResponse();
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestParam List<Long> ids) throws FunctionalException, TechnicalException {
		employeeDeleteManyCoordinator.process(ids);
		return new OkResponse();
	}

}
