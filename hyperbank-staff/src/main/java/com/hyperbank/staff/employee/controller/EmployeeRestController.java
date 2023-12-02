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

import com.hyperbank.staff.employee.api.delete.many.EmployeeDeleteManySniper;
import com.hyperbank.staff.employee.api.delete.one.EmployeeDeleteOneSniper;
import com.hyperbank.staff.employee.api.find.all.EmployeeFindAllSniper;
import com.hyperbank.staff.employee.api.find.many.EmployeeFindManySniper;
import com.hyperbank.staff.employee.api.find.one.EmployeeFindOneSniper;
import com.hyperbank.staff.employee.api.save.many.EmployeeSaveManySniper;
import com.hyperbank.staff.employee.api.save.one.EmployeeSaveOneSniper;
import com.hyperbank.staff.employee.api.update.many.EmployeeUpdateManySniper;
import com.hyperbank.staff.employee.api.update.one.EmployeeUpdateOneSniper;
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

	private final EmployeeSaveOneSniper employeeSaveOneSniper;
	
	private final EmployeeSaveManySniper employeeSaveManySniper;
	
	private final EmployeeFindOneSniper employeeFindOneSniper;
	
	private final EmployeeFindManySniper employeeFindManySniper;
	
	private final EmployeeFindAllSniper employeeFindAllSniper;
	
	private final EmployeeUpdateOneSniper employeeUpdateOneSniper;
	
	private final EmployeeUpdateManySniper employeeUpdateManySniper;
	
	private final EmployeeDeleteOneSniper employeeDeleteOneSniper;
	
	private final EmployeeDeleteManySniper employeeDeleteManySniper;
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody EmployeeResponse findById(@PathVariable Long id) throws FunctionalException, TechnicalException {
		return employeeFindOneSniper.fire(id);
	}

	@GetMapping(value = "/find-many", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<EmployeeResponse> findMany(@RequestParam List<Long> ids) throws FunctionalException, TechnicalException {
		return employeeFindManySniper.fire(ids);
	}
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<EmployeeResponse> findAll() throws FunctionalException, TechnicalException {
		return employeeFindAllSniper.fire();
	}

	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody EmployeeResponse save(@RequestBody final EmployeeSaveRequest saveRequest) throws FunctionalException, TechnicalException {
		return employeeSaveOneSniper.fire(saveRequest);
	}

	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<EmployeeResponse> save(@RequestBody final List<EmployeeSaveRequest> saveRequests) throws FunctionalException, TechnicalException {
		return employeeSaveManySniper.fire(saveRequests);
	}

	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody EmployeeResponse update(@RequestBody final EmployeeUpdateRequest updateRequest) throws FunctionalException, TechnicalException {
		return employeeUpdateOneSniper.fire(updateRequest);
	}

	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<EmployeeResponse> update(@RequestBody final List<EmployeeUpdateRequest> updateRequests) throws FunctionalException, TechnicalException {
		return employeeUpdateManySniper.fire(updateRequests);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable Long id) throws FunctionalException, TechnicalException {
		employeeDeleteOneSniper.fire(id);
		return new OkResponse();
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestParam List<Long> ids) throws FunctionalException, TechnicalException {
		employeeDeleteManySniper.fire(ids);
		return new OkResponse();
	}

}
