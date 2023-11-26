package com.hyperbank.staff.employee.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	
//	private final EmployeeService employeeService;
//	
//	private final EmployeeMapper employeeMapper;
//
//	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody EmployeeResponse findById(@PathVariable Long id) throws FunctionalException {
//		return employeeMapper.toResponse(employeeService.findById(id));
//	}
//
//	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody List<EmployeeResponse> findAll() {
//		return employeeMapper.toResponses(employeeService.findAll());
//	}

	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody EmployeeResponse save(@Valid @RequestBody final EmployeeSaveRequest saveRequest) throws FunctionalException, TechnicalException {
		return employeeSaveOneSniper.fire(saveRequest);
	}

//	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody List<Long> save(@RequestBody final List<EmployeeSaveRequest> saveRequests) throws FunctionalException {
//		ValidatorUtils.validateAll(saveRequests);
//		return employeeService.save(employeeMapper.fromSaveRequestsToEntities(saveRequests));
//	}
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
