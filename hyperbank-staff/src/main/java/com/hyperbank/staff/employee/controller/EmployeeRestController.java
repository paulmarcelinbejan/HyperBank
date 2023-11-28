package com.hyperbank.staff.employee.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyperbank.staff.employee.api.find.all.EmployeeFindAllSniper;
import com.hyperbank.staff.employee.api.find.many.EmployeeFindManySniper;
import com.hyperbank.staff.employee.api.find.one.EmployeeFindOneSniper;
import com.hyperbank.staff.employee.api.save.many.EmployeeSaveManySniper;
import com.hyperbank.staff.employee.api.save.one.EmployeeSaveOneSniper;
import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

import jakarta.validation.Valid;
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
	
//	private final EmployeeService employeeService;
//	
//	private final EmployeeMapper employeeMapper;
//
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody EmployeeResponse findById(@PathVariable Long id) throws FunctionalException, TechnicalException {
		return employeeFindOneSniper.fire(id);
	}

	@GetMapping(value = "/find-many", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<EmployeeResponse> findMany(Long[] ids) throws FunctionalException, TechnicalException {
		return employeeFindManySniper.fire(Arrays.asList(ids));
	}
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<EmployeeResponse> findAll() throws FunctionalException, TechnicalException {
		return employeeFindAllSniper.fire(null);
	}

	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody EmployeeResponse save(@Valid @RequestBody final EmployeeSaveRequest saveRequest) throws FunctionalException, TechnicalException {
		return employeeSaveOneSniper.fire(saveRequest);
	}

	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<EmployeeResponse> save(@RequestBody final List<EmployeeSaveRequest> saveRequests) throws FunctionalException, TechnicalException {
		return employeeSaveManySniper.fire(saveRequests);
	}
//
//	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody Long update(@Valid @RequestBody final EmployeeUpdateRequest updateRequest) throws FunctionalException {
//		return employeeService.update(employeeMapper.fromUpdateRequestToEntity(updateRequest));
//	}
//
//	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody List<Long> update(@RequestBody final List<EmployeeUpdateRequest> updateRequests) throws FunctionalException {
//		ValidatorUtils.validateAll(updateRequests);
//		return employeeService.update(employeeMapper.fromUpdateRequestsToEntities(updateRequests));
//	}
//
//	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody OkResponse delete(@PathVariable Long id) throws FunctionalException {
//		employeeService.delete(id);
//		return new OkResponse();
//	}
//
//	@DeleteMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody OkResponse delete(@RequestBody List<Long> ids) throws FunctionalException {
//		employeeService.deleteMany(ids);
//		return new OkResponse();
//	}

}
